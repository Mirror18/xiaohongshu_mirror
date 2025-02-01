package com.mirror.xiaohongshu.count.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: mirror
 * @Date: 2025/2/2 04:26
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.mirror.xiaohongshu.count.biz.domain.mapper")
public class XiaohongshuCountBizApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(XiaohongshuCountBizApplication.class, args);
    }
}