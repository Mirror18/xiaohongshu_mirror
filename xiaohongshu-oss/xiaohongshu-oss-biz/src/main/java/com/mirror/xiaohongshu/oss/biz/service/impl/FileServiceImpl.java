package com.mirror.xiaohongshu.oss.biz.service.impl;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.oss.biz.service.FileService;
import com.mirror.xiaohongshu.oss.biz.strategy.FileStrategy;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${storage.type}")
    private String strategyType;

    private static final String BUCKET_NAME_MINIO = "xiaohongshu";
    private static final String BUCKET_NAME_ALIYUN = "mirror-hong";

    @Override
    public Response<?> uploadFile(MultipartFile file) {
        String url = "";
        // 上传文件
        if (strategyType.equals("minio")) {
            url = fileStrategy.uploadFile(file, BUCKET_NAME_MINIO);
        } else if (strategyType.equals("aliyun")) {
            url = fileStrategy.uploadFile(file, BUCKET_NAME_ALIYUN);
        } else {
            url = "不可用";
        }
        return Response.success(url);
    }
}