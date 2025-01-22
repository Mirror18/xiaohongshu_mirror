package com.mirror.xiaohongshu.auth.service;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.auth.model.vo.user.UserLoginReqVO;

/**
 * @Auther: mirror
 * @Date: 2025/1/15 11:48
 * @Description:
 */
public interface UserService {

    /**
     * 登录与注册
     * @param userLoginReqVO
     * @return
     */
    Response<String> loginAndRegister(UserLoginReqVO userLoginReqVO);

    /**
     * 退出登录
     * @return
     */
    Response<?> logout(Long userId);
}
