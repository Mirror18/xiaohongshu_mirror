package com.mirror.xiaohongshu.note.biz.service;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.note.biz.model.vo.PublishNoteReqVO;

/**
 * @Auther: mirror
 * @Date: 2025/1/29 02:15
 * @Description:
 */
public interface NoteService {

    /**
     * 笔记发布
     * @param publishNoteReqVO
     * @return
     */
    Response<?> publishNote(PublishNoteReqVO publishNoteReqVO);

}