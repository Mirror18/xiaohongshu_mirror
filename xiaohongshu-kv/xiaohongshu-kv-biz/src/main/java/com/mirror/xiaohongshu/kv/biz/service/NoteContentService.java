package com.mirror.xiaohongshu.kv.biz.service;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.kv.dto.req.AddNoteContentReqDTO;
import com.mirror.xiaohongshu.kv.dto.req.DeleteNoteContentReqDTO;
import com.mirror.xiaohongshu.kv.dto.req.FindNoteContentReqDTO;
import com.mirror.xiaohongshu.kv.dto.rsp.FindNoteContentRspDTO;

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

    /**
     * 查询笔记内容
     *
     * @param findNoteContentReqDTO
     * @return
     */
    Response<FindNoteContentRspDTO> findNoteContent(FindNoteContentReqDTO findNoteContentReqDTO);

    /**
     * 删除笔记内容
     *
     * @param deleteNoteContentReqDTO
     * @return
     */
    Response<?> deleteNoteContent(DeleteNoteContentReqDTO deleteNoteContentReqDTO);

}