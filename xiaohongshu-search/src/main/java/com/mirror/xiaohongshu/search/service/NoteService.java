package com.mirror.xiaohongshu.search.service;

import com.mirror.framework.common.response.PageResponse;
import com.mirror.xiaohongshu.search.model.vo.SearchNoteReqVO;
import com.mirror.xiaohongshu.search.model.vo.SearchNoteRspVO;

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
}
