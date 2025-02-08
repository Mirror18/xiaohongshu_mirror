package com.mirror.xiaohongshu.search.biz.service;

import com.mirror.framework.common.response.PageResponse;
import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.dto.RebuildUserDocumentReqDTO;
import com.mirror.xiaohongshu.search.biz.model.vo.SearchUserReqVO;
import com.mirror.xiaohongshu.search.biz.model.vo.SearchUserRspVO;

/**
 * @Auther: mirror
 * @Date: 2025/2/8 11:29
 * @Description:
 */
public interface UserService {

    /**
     * 搜索用户
     * @param searchUserReqVO
     * @return
     */
    PageResponse<SearchUserRspVO> searchUser(SearchUserReqVO searchUserReqVO);

    /**
     * 重建用户文档
     * @param rebuildUserDocumentReqDTO
     * @return
     */
    Response<Long> rebuildDocument(RebuildUserDocumentReqDTO rebuildUserDocumentReqDTO);
}
