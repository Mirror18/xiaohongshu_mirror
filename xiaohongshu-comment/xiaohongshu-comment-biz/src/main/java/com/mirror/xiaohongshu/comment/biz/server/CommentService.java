package com.mirror.xiaohongshu.comment.biz.server;

import com.mirror.xiaohongshu.comment.biz.model.vo.PublishCommentReqVO;
import com.mirror.framework.common.response.Response;
/**
 * @Auther: mirror
 * @Date: 2025/2/19 12:52
 * @Description:
 */
public interface CommentService {

    /**
     * 发布评论
     * @param publishCommentReqVO
     * @return
     */
    Response<?> publishComment(PublishCommentReqVO publishCommentReqVO);
}