package com.mirror.xiaohongshu.data.align;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: mirror
 * @Date: 2025/2/6 17:52
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.mirror.xiaohongshu.data.align.domain.mapper")
public class XiaohongshuDataAlignApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(XiaohongshuDataAlignApplication.class, args);
    }
}