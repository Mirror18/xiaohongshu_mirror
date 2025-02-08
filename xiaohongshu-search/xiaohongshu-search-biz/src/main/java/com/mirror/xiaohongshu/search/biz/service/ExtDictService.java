package com.mirror.xiaohongshu.search.biz.service;

import org.springframework.http.ResponseEntity;

/**
 * @Auther: mirror
 * @Date: 2025/2/8 12:46
 * @Description:
 */
public interface ExtDictService {

    /**
     * 获取热更新词典
     * @return
     */
    ResponseEntity<String> getHotUpdateExtDict();
}