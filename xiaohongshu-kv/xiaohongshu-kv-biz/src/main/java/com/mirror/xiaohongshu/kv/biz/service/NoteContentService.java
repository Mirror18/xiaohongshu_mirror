package com.mirror.xiaohongshu.kv.biz.service;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.kv.dto.req.AddNoteContentReqDTO;

/**
 * @Auther: mirror
 * @Date: 2025/1/27 09:25
 * @Description:
 */
public interface NoteContentService {

    /**
     * 添加笔记内容
     *
     * @param addNoteContentReqDTO
     * @return
     */
    Response<?> addNoteContent(AddNoteContentReqDTO addNoteContentReqDTO);

}