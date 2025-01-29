package com.mirror.xiaohongshu.note.biz.constant;

/**
 * @Auther: mirror
 * @Date: 2025/1/30 04:30
 * @Description:
 */
public class RedisKeyConstants {

    /**
     * 笔记详情 KEY 前缀
     */
    public static final String NOTE_DETAIL_KEY = "note:detail:";


    /**
     * 构建完整的笔记详情 KEY
     * @param noteId
     * @return
     */
    public static String buildNoteDetailKey(Long noteId) {
        return NOTE_DETAIL_KEY + noteId;
    }

}