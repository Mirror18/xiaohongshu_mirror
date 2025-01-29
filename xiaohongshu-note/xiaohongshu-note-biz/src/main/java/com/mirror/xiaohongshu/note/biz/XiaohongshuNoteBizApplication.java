package com.mirror.xiaohongshu.note.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: mirror
 * @Date: 2025/1/28 14:29
 * @Description:
 */
@SpringBootApplication
@MapperScan(basePackages = "com.mirror.xiaohongshu.note.biz.domain.mapper")
@EnableFeignClients(basePackages = "com.mirror.xiaohongshu")
public class XiaohongshuNoteBizApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(XiaohongshuNoteBizApplication.class, args);
    }
}