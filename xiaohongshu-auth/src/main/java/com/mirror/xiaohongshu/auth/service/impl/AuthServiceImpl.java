package com.mirror.xiaohongshu.auth.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.google.common.base.Preconditions;
import com.mirror.framework.biz.context.holder.LoginUserContextHolder;
import com.mirror.framework.common.exception.BizException;
import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.auth.constant.RedisKeyConstants;
//import com.mirror.xiaohongshu.auth.domain.mapper.RoleDOMapper;
//import com.mirror.xiaohongshu.auth.domain.mapper.UserDOMapper;
//import com.mirror.xiaohongshu.auth.domain.mapper.UserRoleDOMapper;
import com.mirror.xiaohongshu.auth.enums.LoginTypeEnum;
import com.mirror.xiaohongshu.auth.enums.ResponseCodeEnum;
//import com.mirror.xiaohongshu.auth.filter.LoginUserContextHolder;
import com.mirror.xiaohongshu.auth.model.vo.user.UpdatePasswordReqVO;
import com.mirror.xiaohongshu.auth.model.vo.user.UserLoginReqVO;
import com.mirror.xiaohongshu.auth.rpc.UserRpcService;
import com.mirror.xiaohongshu.auth.service.AuthService;
import com.mirror.xiaohongshu.user.dto.resp.FindUserByPhoneRspDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Objects;

/**
 * @Auther: mirror
 * @Date: 2025/1/15 11:49
 * @Description:
 */
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

//    @Resource
//    private UserDOMapper userDOMapper;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
//    @Resource
//    private UserRoleDOMapper userRoleDOMapper;
//    @Resource
//    private TransactionTemplate transactionTemplate;
//    @Resource
//    private RoleDOMapper roleDOMapper;

    @Resource(name = "taskExecutor")
    //@Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Resource
    private UserRpcService userRpcService;


    /**
     * 登录与注册
     *
     * @param userLoginReqVO
     * @return
     */
    @Override
    public Response<String> loginAndRegister(UserLoginReqVO userLoginReqVO) {
        String phone = userLoginReqVO.getPhone();
        Integer type = userLoginReqVO.getType();

        LoginTypeEnum loginTypeEnum = LoginTypeEnum.valueOf(type);

        Long userId = null;

        // 判断登录类型
        switch (loginTypeEnum) {
            case VERIFICATION_CODE: // 验证码登录
                String verificationCode = userLoginReqVO.getCode();

//                // 校验入参验证码是否为空
//                if (StringUtils.isBlank(verificationCode)) {
//                    return Response.fail(ResponseCodeEnum.PARAM_NOT_VALID.getErrorCode(), "验证码不能为空");
//                }
                // 校验入参验证码是否为空
                Preconditions.checkArgument(StringUtils.isNotBlank(verificationCode), "验证码不能为空");

                // 构建验证码 Redis Key
                String key = RedisKeyConstants.buildVerificationCodeKey(phone);
                // 查询存储在 Redis 中该用户的登录验证码
                String sentCode = (String) redisTemplate.opsForValue().get(key);

                // 判断用户提交的验证码，与 Redis 中的验证码是否一致
                if (!StringUtils.equals(verificationCode, sentCode)) {
                    throw new BizException(ResponseCodeEnum.VERIFICATION_CODE_ERROR);
                }

//                // 通过手机号查询记录
//                UserDO userDO = userDOMapper.selectByPhone(phone);
//
//                log.info("==> 用户是否注册, phone: {}, userDO: {}", phone, JsonUtils.toJsonString(userDO));
//
//                // 判断是否注册
//                if (Objects.isNull(userDO)) {
////                    // 若此用户还没有注册，系统自动注册该用户
////                    userId = registerUser(phone);
//                    // RPC: 调用用户服务，注册用户
//                    Long userIdTmp = userRpcService.registerUser(phone);
//
//                    // 若调用用户服务，返回的用户 ID 为空，则提示登录失败
//                    if (Objects.isNull(userIdTmp)) {
//                        throw new BizException(ResponseCodeEnum.LOGIN_FAIL);
//                    }
//
//                    userId = userIdTmp;
//                } else {
//                    // 已注册，则获取其用户 ID
//                    userId = userDO.getId();
//                }
                // RPC: 调用用户服务，注册用户
                Long userIdTmp = userRpcService.registerUser(phone);

                // 若调用用户服务，返回的用户 ID 为空，则提示登录失败
                if (Objects.isNull(userIdTmp)) {
                    throw new BizException(ResponseCodeEnum.LOGIN_FAIL);
                }

                userId = userIdTmp;
                break;
            case PASSWORD: // 密码登录
                String password = userLoginReqVO.getPassword();

                // RPC: 调用用户服务，通过手机号查询用户
                FindUserByPhoneRspDTO findUserByPhoneRspDTO = userRpcService.findUserByPhone(phone);

                // 判断该手机号是否注册
                if (Objects.isNull(findUserByPhoneRspDTO)) {
                    throw new BizException(ResponseCodeEnum.USER_NOT_FOUND);
                }

                // 拿到密文密码
                String encodePassword = findUserByPhoneRspDTO.getPassword();

                // 匹配密码是否一致
                boolean isPasswordCorrect = passwordEncoder.matches(password, encodePassword);

                // 如果不正确，则抛出业务异常，提示用户名或者密码不正确
                if (!isPasswordCorrect) {
                    throw new BizException(ResponseCodeEnum.PHONE_OR_PASSWORD_ERROR);
                }

                userId = findUserByPhoneRspDTO.getId();
                break;
            default:
                break;
        }

        // SaToken 登录用户，并返回 token 令牌
        // SaToken 登录用户, 入参为用户 ID
        StpUtil.login(userId);

        // 获取 Token 令牌
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();

        // 返回 Token 令牌
        return Response.success(tokenInfo.tokenValue);

    }

    /**
     * 退出登录
     *
     * @param
     * @return
     */
    @Override
    public Response<?> logout() {
        Long userId = LoginUserContextHolder.getUserId();

        log.info("==> 用户退出登录, userId: {}", userId);

        threadPoolTaskExecutor.submit(() -> {
            Long userId2 = LoginUserContextHolder.getUserId();
            log.info("==> 异步线程中获取 userId: {}", userId2);
        });

        // 退出登录 (指定用户 ID)
        StpUtil.logout(userId);

        return Response.success();
    }

    @Resource
    private PasswordEncoder passwordEncoder;
    /**
     * 修改密码
     *
     * @param updatePasswordReqVO
     * @return
     */
    @Override
    public Response<?> updatePassword(UpdatePasswordReqVO updatePasswordReqVO) {
        // 新密码
        String newPassword = updatePasswordReqVO.getNewPassword();
        // 密码加密
        String encodePassword = passwordEncoder.encode(newPassword);

//        // 获取当前请求对应的用户 ID
//        Long userId = LoginUserContextHolder.getUserId();
//
//        UserDO userDO = UserDO.builder()
//                .id(userId)
//                .password(encodePassword)
//                .updateTime(LocalDateTime.now())
//                .build();
//        // 更新密码
//        userDOMapper.updateByPrimaryKeySelective(userDO);

        // RPC: 调用用户服务：更新密码
        userRpcService.updatePassword(encodePassword);

        return Response.success();
    }

//    /**
//     * 系统自动注册用户
//     * @param phone
//     * @return
//     */
//    @Transactional(rollbackFor = Exception.class)
//    public Long registerUser(String phone) {
//        // 获取全局自增的小红书 ID
//        Long xiaohongshuId = redisTemplate.opsForValue().increment(RedisKeyConstants.XIAOHONGSHU_ID_GENERATOR_KEY);
//
//        UserDO userDO = UserDO.builder()
//                .phone(phone)
//                .xiaohongshuId(String.valueOf(xiaohongshuId)) // 自动生成小红书号 ID
//                .nickname("小红薯" + xiaohongshuId) // 自动生成昵称, 如：小红薯10000
//                .status(StatusEnum.ENABLE.getValue()) // 状态为启用
//                .createTime(LocalDateTime.now())
//                .updateTime(LocalDateTime.now())
//                .isDeleted(DeletedEnum.NO.getValue()) // 逻辑删除
//                .build();
//
//        // 添加入库
//        userDOMapper.insert(userDO);
//
//        // 获取刚刚添加入库的用户 ID
//        Long userId = userDO.getId();
//
//        // 给该用户分配一个默认角色
//        UserRoleDO userRoleDO = UserRoleDO.builder()
//                .userId(userId)
//                .roleId(RoleConstants.COMMON_USER_ROLE_ID)
//                .createTime(LocalDateTime.now())
//                .updateTime(LocalDateTime.now())
//                .isDeleted(DeletedEnum.NO.getValue())
//                .build();
//        userRoleDOMapper.insert(userRoleDO);
//
//        // 将该用户的角色 ID 存入 Redis 中
//        List<Long> roles = Lists.newArrayList();
//        roles.add(RoleConstants.COMMON_USER_ROLE_ID);
//        String userRolesKey = RedisKeyConstants.buildUserRoleKey(phone);
//        redisTemplate.opsForValue().set(userRolesKey, JsonUtils.toJsonString(roles));
//
//        return userId;
//    }

//    /**
//     * 系统自动注册用户
//     *
//     * @param phone
//     * @return
//     */
//    private Long registerUser(String phone) {
//        return transactionTemplate.execute(status -> {
//            try {
//                // 获取全局自增的小红书 ID
//                Long xiaohongshuId = redisTemplate.opsForValue().increment(RedisKeyConstants.XIAOHONGSHU_ID_GENERATOR_KEY);
//
//                UserDO userDO = UserDO.builder()
//                        .phone(phone)
//                        .xiaohongshuId(String.valueOf(xiaohongshuId)) // 自动生成小红书号 ID
//                        .nickname("小红薯" + xiaohongshuId) // 自动生成昵称, 如：小红薯10000
//                        .status(StatusEnum.ENABLE.getValue()) // 状态为启用
//                        .createTime(LocalDateTime.now())
//                        .updateTime(LocalDateTime.now())
//                        .isDeleted(DeletedEnum.NO.getValue()) // 逻辑删除
//                        .build();
//
//                // 添加入库
//                userDOMapper.insert(userDO);
//
////                int i = 1 / 0;
//
//                // 获取刚刚添加入库的用户 ID
//                Long userId = userDO.getId();
//
//                // 给该用户分配一个默认角色
//                UserRoleDO userRoleDO = UserRoleDO.builder()
//                        .userId(userId)
//                        .roleId(RoleConstants.COMMON_USER_ROLE_ID)
//                        .createTime(LocalDateTime.now())
//                        .updateTime(LocalDateTime.now())
//                        .isDeleted(DeletedEnum.NO.getValue())
//                        .build();
//                userRoleDOMapper.insert(userRoleDO);
//
//                RoleDO roleDO = roleDOMapper.selectByPrimaryKey(RoleConstants.COMMON_USER_ROLE_ID);
//
//                // 将该用户的角色 ID 存入 Redis 中，指定初始容量为 1，这样可以减少在扩容时的性能开销
//                List<String> roles = new ArrayList<>(1);
//                roles.add(roleDO.getRoleKey());
//
//                String userRolesKey = RedisKeyConstants.buildUserRoleKey(userId);
//                redisTemplate.opsForValue().set(userRolesKey, JsonUtils.toJsonString(roles));
//
//                return userId;
//            } catch (Exception e) {
//                status.setRollbackOnly(); // 标记事务为回滚
//                log.error("==> 系统注册用户异常: ", e);
//                return null;
//            }
//        });
//    }


}