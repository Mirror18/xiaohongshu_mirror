package com.mirror.xiaohongshu.search.biz.service;

import com.mirror.framework.common.response.PageResponse;
import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.dto.RebuildNoteDocumentReqDTO;
import com.mirror.xiaohongshu.search.biz.model.vo.SearchNoteReqVO;
import com.mirror.xiaohongshu.search.biz.model.vo.SearchNoteRspVO;

/**
 * @Auther: mirror
 * @Date: 2025/2/8 12:04
 * @Description:
 */
public interface NoteService {

    /**
     * 搜索笔记
     * @param searchNoteReqVO
     * @return
     */
    PageResponse<SearchNoteRspVO> searchNote(SearchNoteReqVO searchNoteReqVO);

    /**
     * 重建笔记文档
     * @param rebuildNoteDocumentReqDTO
     * @return
     */
    Response<Long> rebuildDocument(RebuildNoteDocumentReqDTO rebuildNoteDocumentReqDTO);


}
