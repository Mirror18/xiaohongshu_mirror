package com.mirror.xiaohongshu.auth.rpc;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.user.api.UserFeignApi;
import com.mirror.xiaohongshu.user.dto.req.RegisterUserReqDTO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @Auther: mirror
 * @Date: 2025/1/26 05:12
 * @Description:
 */
@Component
public class UserRpcService {

    @Resource
    private UserFeignApi userFeignApi;

    /**
     * 用户注册
     *
     * @param phone
     * @return
     */
    public Long registerUser(String phone) {
        RegisterUserReqDTO registerUserReqDTO = new RegisterUserReqDTO();
        registerUserReqDTO.setPhone(phone);

        Response<Long> response = userFeignApi.registerUser(registerUserReqDTO);

        if (!response.isSuccess()) {
            return null;
        }

        return response.getData();
    }

}