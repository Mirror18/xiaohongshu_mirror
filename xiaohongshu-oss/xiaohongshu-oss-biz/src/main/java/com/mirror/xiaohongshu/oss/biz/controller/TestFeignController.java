package com.mirror.xiaohongshu.oss.biz.controller;

import com.mirror.framework.biz.operationlog.aspect.ApiOperationLog;
import com.mirror.framework.common.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: mirror
 * @Date: 2025/1/25 17:40
 * @Description:
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class TestFeignController {

    @PostMapping(value = "/test")
    @ApiOperationLog(description = "Feign 测试接口")
    public Response<?> test() {
        return Response.success();
    }

}