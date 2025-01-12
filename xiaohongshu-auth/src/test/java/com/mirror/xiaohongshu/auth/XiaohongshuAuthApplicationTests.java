package com.mirror.xiaohongshu.auth;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * @Auther: mirror
 * @Date: 2025/1/13 03:56
 * @Description:
 */
@SpringBootTest
@Slf4j
class XiaohashuAuthApplicationTests {

    @Resource
    private UserDOMapper userDOMapper;

    /**
     * 测试插入数据
     */
    @Test
    void testInsert() {
        UserDO userDO = UserDO.builder()
                .username("mirror")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        userDOMapper.insert(userDO);
    }

}