package com.mirror.framework.common.util;

import com.mirror.framework.common.constant.DateConstants;

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

    /**
     * LocalDateTime 转 String 字符串
     * @param time
     * @return
     */
    public static String localDateTime2String(LocalDateTime time) {
        return time.format(DateConstants.DATE_FORMAT_Y_M_D_H_M_S);
    }

}