package com.mirror.xiaohongshu.oss.biz.strategy.impl;

import com.mirror.xiaohongshu.oss.biz.strategy.FileStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: mirror
 * @Date: 2025/1/24 09:21
 * @Description:
 */
@Slf4j
public class MinioFileStrategy implements FileStrategy {

    @Override
    public String uploadFile(MultipartFile file, String bucketName) {
        log.info("## 上传文件至 Minio ...");
        return null;
    }
}