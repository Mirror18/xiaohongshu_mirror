package com.mirror.xiaohongshu.search;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Auther: mirror
 * @Date: 2025/2/8 11:11
 * @Description:
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.mirror.xiaohongshu.search.domain.mapper")
public class XiaohongshuSearchApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(XiaohongshuSearchApplication.class, args);
    }
}