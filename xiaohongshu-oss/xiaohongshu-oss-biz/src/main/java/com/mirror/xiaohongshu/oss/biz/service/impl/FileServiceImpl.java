package com.mirror.xiaohongshu.oss.biz.service.impl;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.oss.biz.service.FileService;
import com.mirror.xiaohongshu.oss.biz.strategy.FileStrategy;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: mirror
 * @Date: 2025/1/24 09:25
 * @Description:
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Resource
    private FileStrategy fileStrategy;

    @Override
    public Response<?> uploadFile(MultipartFile file) {
        // 上传文件到
        fileStrategy.uploadFile(file, "xiaohongshu");

        return Response.success();
    }
}