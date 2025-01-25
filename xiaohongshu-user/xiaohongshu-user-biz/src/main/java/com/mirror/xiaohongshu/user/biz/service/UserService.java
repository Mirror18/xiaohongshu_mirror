package com.mirror.xiaohongshu.user.biz.service;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.user.biz.model.vo.UpdateUserInfoReqVO;
import com.mirror.xiaohongshu.user.dto.req.RegisterUserReqDTO;

/**
 * @Auther: mirror
 * @Date: 2025/1/25 10:49
 * @Description:
 */
public interface UserService {

    /**
     * 更新用户信息
     *
     * @param updateUserInfoReqVO
     * @return
     */
    Response<?> updateUserInfo(UpdateUserInfoReqVO updateUserInfoReqVO);

    /**
     * 用户注册
     *
     * @param registerUserReqDTO
     * @return
     */
    Response<Long> register(RegisterUserReqDTO registerUserReqDTO);
}