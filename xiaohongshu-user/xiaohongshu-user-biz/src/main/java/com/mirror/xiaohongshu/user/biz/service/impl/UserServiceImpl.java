package com.mirror.xiaohongshu.user.biz.service.impl;

import com.google.common.base.Preconditions;
import com.mirror.framework.biz.context.holder.LoginUserContextHolder;
import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.user.biz.domain.dataobject.UserDO;
import com.mirror.xiaohongshu.user.biz.domain.mapper.UserDOMapper;
import com.mirror.xiaohongshu.user.biz.enums.ResponseCodeEnum;
import com.mirror.xiaohongshu.user.biz.enums.SexEnum;
import com.mirror.xiaohongshu.user.biz.model.vo.UpdateUserInfoReqVO;
import com.mirror.xiaohongshu.user.biz.service.UserService;
import com.mirror.xiaohongshu.user.biz.util.ParamUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Auther: mirror
 * @Date: 2025/1/25 10:49
 * @Description:
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserDOMapper userDOMapper;

    /**
     * 更新用户信息
     *
     * @param updateUserInfoReqVO
     * @return
     */
    @Override
    public Response<?> updateUserInfo(UpdateUserInfoReqVO updateUserInfoReqVO) {
        UserDO userDO = new UserDO();
        // 设置当前需要更新的用户 ID
        userDO.setId(LoginUserContextHolder.getUserId());
        // 标识位：是否需要更新
        boolean needUpdate = false;

        // 头像
        MultipartFile avatarFile = updateUserInfoReqVO.getAvatar();

        if (Objects.nonNull(avatarFile)) {
            // todo: 调用对象存储服务上传文件
        }

        // 昵称
        String nickname = updateUserInfoReqVO.getNickname();
        if (StringUtils.isNotBlank(nickname)) {
            Preconditions.checkArgument(ParamUtils.checkNickname(nickname), ResponseCodeEnum.NICK_NAME_VALID_FAIL.getErrorMessage());
            userDO.setNickname(nickname);
            needUpdate = true;
        }

        // 小红书号
        String xiaohongshuId = updateUserInfoReqVO.getXiaohongshuId();
        if (StringUtils.isNotBlank(xiaohongshuId)) {
            Preconditions.checkArgument(ParamUtils.checkXiaohongshuId(xiaohongshuId), ResponseCodeEnum.XIAOHONGSHU_ID_VALID_FAIL.getErrorMessage());
            userDO.setXiaohongshuId(xiaohongshuId);
            needUpdate = true;
        }

        // 性别
        Integer sex = updateUserInfoReqVO.getSex();
        if (Objects.nonNull(sex)) {
            Preconditions.checkArgument(SexEnum.isValid(sex), ResponseCodeEnum.SEX_VALID_FAIL.getErrorMessage());
            userDO.setSex(sex);
            needUpdate = true;
        }

        // 生日
        LocalDate birthday = updateUserInfoReqVO.getBirthday();
        if (Objects.nonNull(birthday)) {
            userDO.setBirthday(birthday);
            needUpdate = true;
        }

        // 个人简介
        String introduction = updateUserInfoReqVO.getIntroduction();
        if (StringUtils.isNotBlank(introduction)) {
            Preconditions.checkArgument(ParamUtils.checkLength(introduction, 100), ResponseCodeEnum.INTRODUCTION_VALID_FAIL.getErrorMessage());
            userDO.setIntroduction(introduction);
            needUpdate = true;
        }

        // 背景图
        MultipartFile backgroundImgFile = updateUserInfoReqVO.getBackgroundImg();
        if (Objects.nonNull(backgroundImgFile)) {
            // todo: 调用对象存储服务上传文件
        }

        if (needUpdate) {
            // 更新用户信息
            userDO.setUpdateTime(LocalDateTime.now());
            userDOMapper.updateByPrimaryKeySelective(userDO);
        }
        return Response.success();
    }
}
