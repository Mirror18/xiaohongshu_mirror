package com.mirror.xiaohongshu.search.service;

import com.mirror.framework.common.response.PageResponse;
import com.mirror.xiaohongshu.search.model.vo.SearchUserReqVO;
import com.mirror.xiaohongshu.search.model.vo.SearchUserRspVO;

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
}
