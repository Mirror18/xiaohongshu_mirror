package com.mirror.xiaohongshu.auth.controller;

import com.mirror.framework.common.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: mirror
 * @Date: 2025/1/12 21:44
 * @Description:
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public Response<String> test() {
        return Response.success("hello,mirror");
    }
}