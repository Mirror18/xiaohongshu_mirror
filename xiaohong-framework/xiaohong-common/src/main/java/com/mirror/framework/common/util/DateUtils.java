package com.mirror.framework.common.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @Auther: mirror
 * @Date: 2025/2/1 12:13
 * @Description:
 */
public class DateUtils {

    /**
     * LocalDateTime 转时间戳
     *
     * @param localDateTime
     * @return
     */
    public static long localDateTime2Timestamp(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
    }
}