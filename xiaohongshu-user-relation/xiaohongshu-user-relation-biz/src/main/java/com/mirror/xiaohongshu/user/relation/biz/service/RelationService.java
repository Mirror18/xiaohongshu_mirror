package com.mirror.xiaohongshu.user.relation.biz.service;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.user.relation.biz.model.vo.FollowUserReqVO;
import com.mirror.xiaohongshu.user.relation.biz.model.vo.UnfollowUserReqVO;

/**
 * @Auther: mirror
 * @Date: 2025/1/31 16:43
 * @Description:
 */
public interface RelationService {

    /**
     * 关注用户
     * @param followUserReqVO
     * @return
     */
    Response<?> follow(FollowUserReqVO followUserReqVO);
    /**
     * 取关用户
     * @param unfollowUserReqVO
     * @return
     */
    Response<?> unfollow(UnfollowUserReqVO unfollowUserReqVO);

}