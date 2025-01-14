package com.mirror.xiaohongshu.auth;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Auther: mirror
 * @Date: 2025/1/15 04:09
 * @Description:
 */
@SpringBootTest
@Slf4j
public class ThreadPoolTaskExecutorTests {

    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /**
     * 测试线程池
     */
    @Test
    void testSubmit() {
        threadPoolTaskExecutor.submit(() -> log.info("异步线程中说: mirror"));
    }
}