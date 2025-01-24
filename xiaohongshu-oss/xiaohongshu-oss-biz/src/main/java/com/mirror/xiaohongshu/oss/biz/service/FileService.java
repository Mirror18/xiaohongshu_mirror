package com.mirror.xiaohongshu.oss.biz.service;

import com.mirror.framework.common.response.Response;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: mirror
 * @Date: 2025/1/24 09:24
 * @Description:
 */
public interface FileService {

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    Response<?> uploadFile(MultipartFile file);
}