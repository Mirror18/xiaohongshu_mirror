package com.mirror.xiaohongshu.user.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: mirror
 * @Date: 2025/1/24 13:15
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.mirror.xiaohongshu.user.biz.domain.mapper")
@EnableFeignClients("com.mirror.xiaohongshu")
public class XiaohongshuUserBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiaohongshuUserBizApplication.class, args);
    }
}