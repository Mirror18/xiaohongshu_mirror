package com.mirror.xiaohongshu.auth;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mirror
 * @Auther: mirror
 * @Date: 2025/1/12 21:45
 * @Description:
 */
@SpringBootApplication
//@MapperScan("com.mirror.xiaohongshu.auth.domain.mapper")
@EnableFeignClients(basePackages = "com.mirror.xiaohongshu")
public class XiaohongshuAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiaohongshuAuthApplication.class, args);
    }
}