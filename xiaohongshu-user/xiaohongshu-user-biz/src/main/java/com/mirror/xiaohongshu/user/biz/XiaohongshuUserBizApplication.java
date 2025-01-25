package com.mirror.xiaohongshu.user.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: mirror
 * @Date: 2025/1/24 13:15
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.mirror.xiaohongshu.user.biz.domain.mapper")
public class XiaohongshuUserBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiaohongshuUserBizApplication.class, args);
    }
}