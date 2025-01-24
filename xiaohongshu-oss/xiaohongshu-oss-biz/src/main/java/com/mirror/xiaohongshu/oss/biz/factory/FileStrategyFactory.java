package com.mirror.xiaohongshu.oss.biz.factory;

import com.mirror.xiaohongshu.oss.biz.strategy.FileStrategy;
import com.mirror.xiaohongshu.oss.biz.strategy.impl.AliyunOSSFileStrategy;
import com.mirror.xiaohongshu.oss.biz.strategy.impl.MinioFileStrategy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: mirror
 * @Date: 2025/1/24 09:23
 * @Description:
 */
@Configuration
public class FileStrategyFactory {

    @Value("${storage.type}")
    private String strategyType;

    @Bean
    public FileStrategy getFileStrategy() {
        if (StringUtils.equals(strategyType, "minio")) {
            return new MinioFileStrategy();
        } else if (StringUtils.equals(strategyType, "aliyun")) {
            return new AliyunOSSFileStrategy();
        }

        throw new IllegalArgumentException("不可用的存储类型");
    }

}