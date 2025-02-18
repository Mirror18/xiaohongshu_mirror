package com.mirror.xiaohongshu.comment.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: mirror
 * @Date: 2025/2/18 16:08
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.mirror.xiaohongshu.comment.biz.domain.mapper")
public class XiaohongshuCommentBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiaohongshuCommentBizApplication.class, args);
    }
}