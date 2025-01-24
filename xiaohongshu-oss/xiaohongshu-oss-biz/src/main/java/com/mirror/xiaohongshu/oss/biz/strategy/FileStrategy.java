package com.mirror.xiaohongshu.oss.biz.strategy;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: mirror
 * @Date: 2025/1/24 09:21
 * @Description: 文件策略接口
 */
public interface FileStrategy {

    /**
     * 文件上传
     *
     * @param file
     * @param bucketName
     * @return
     */
    String uploadFile(MultipartFile file, String bucketName);

}