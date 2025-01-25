package com.mirror.xiaohongshu.oss.api;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.oss.constants.ApiConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Auther: mirror
 * @Date: 2025/1/25 17:43
 * @Description:
 */
@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface FileFeignApi {

    String PREFIX = "/file";

    @PostMapping(value = PREFIX + "/test")
    Response<?> test();

}