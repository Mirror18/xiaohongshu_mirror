package com.mirror.xiaohongshu.user.api;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.user.constant.ApiConstants;
import com.mirror.xiaohongshu.user.dto.req.RegisterUserReqDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Auther: mirror
 * @Date: 2025/1/26 05:09
 * @Description:
 */
@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface UserFeignApi {

    String PREFIX = "/user";

    /**
     * 用户注册
     *
     * @param registerUserReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/register")
    Response<Long> registerUser(@RequestBody RegisterUserReqDTO registerUserReqDTO);

}
