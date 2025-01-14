package com.mirror.xiaohongshu.auth;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Auther: mirror
 * @Date: 2025/1/14 08:36
 * @Description:
 */
@SpringBootTest
@Slf4j
class RedisTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * set key value
     */
    @Test
    void testSetKeyValue() {
        // 添加一个 key 为 name, value 值为 mirror
        redisTemplate.opsForValue().set("name", "mirror");
    }

    /**
     * 判断某个 key 是否存在
     */
    @Test
    void testHasKey() {
        log.info("key 是否存在：{}", Boolean.TRUE.equals(redisTemplate.hasKey("name")));
    }

    /**
     * 获取某个 key 的 value
     */
    @Test
    void testGetValue() {
        log.info("value 值：{}", redisTemplate.opsForValue().get("name"));
    }

    /**
     * 删除某个 key
     */
    @Test
    void testDelete() {
        redisTemplate.delete("name");
    }
}