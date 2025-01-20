package com.mirror.xiaohongshu.auth.alarm;

/**
 * @Auther: mirror
 * @Date: 2025/1/20 14:22
 * @Description:
 */
public interface AlarmInterface {

    /**
     * 发送告警信息
     *
     * @param message
     * @return
     */
    boolean send(String message);
}