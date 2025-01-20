package com.mirror.xiaohongshu.auth.controller;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: mirror
 * @Date: 2025/1/20 13:53
 * @Description:
 */
@RestController
@Slf4j
public class TestController {

//    @Value("${rate-limit.api.limit}")
//    private Integer limit;
@NacosValue(value = "${rate-limit.api.limit}", autoRefreshed = true)
private Integer limit;

    @GetMapping("/test")
    public String test() {
        return "当前限流阈值为: " + limit;
    }

}