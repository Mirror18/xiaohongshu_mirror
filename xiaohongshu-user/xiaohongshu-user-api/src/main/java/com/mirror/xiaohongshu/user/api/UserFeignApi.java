package com.mirror.xiaohongshu.user.api;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.user.constant.ApiConstants;
import com.mirror.xiaohongshu.user.dto.req.FindUserByPhoneReqDTO;
import com.mirror.xiaohongshu.user.dto.req.RegisterUserReqDTO;
import com.mirror.xiaohongshu.user.dto.resp.FindUserByPhoneRspDTO;
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

    /**
     * 根据手机号查询用户信息
     *
     * @param findUserByPhoneReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/findByPhone")
    Response<FindUserByPhoneRspDTO> findByPhone(@RequestBody FindUserByPhoneReqDTO findUserByPhoneReqDTO);


}
