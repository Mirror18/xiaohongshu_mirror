package com.mirror.xiaohongshu.note.biz.service;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.note.biz.model.vo.FindNoteDetailReqVO;
import com.mirror.xiaohongshu.note.biz.model.vo.FindNoteDetailRspVO;
import com.mirror.xiaohongshu.note.biz.model.vo.PublishNoteReqVO;
import com.mirror.xiaohongshu.note.biz.model.vo.UpdateNoteReqVO;

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

    /**
     * 笔记详情
     * @param findNoteDetailReqVO
     * @return
     */
    Response<FindNoteDetailRspVO> findNoteDetail(FindNoteDetailReqVO findNoteDetailReqVO);

    /**
     * 笔记更新
     * @param updateNoteReqVO
     * @return
     */
    Response<?> updateNote(UpdateNoteReqVO updateNoteReqVO);

    /**
     * 删除本地笔记缓存
     * @param noteId
     */
    void deleteNoteLocalCache(Long noteId);

}