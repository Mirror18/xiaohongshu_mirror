package com.mirror.xiaohongshu.user.relation.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: mirror
 * @Date: 2025/1/31 15:22
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.mirror.xiaohongshu.user.relation.biz.domain.mapper")
public class XiaohongshuUserRelationBizApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(XiaohongshuUserRelationBizApplication.class, args);
    }
}