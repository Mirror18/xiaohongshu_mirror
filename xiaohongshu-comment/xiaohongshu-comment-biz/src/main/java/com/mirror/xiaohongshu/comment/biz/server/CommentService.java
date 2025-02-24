package com.mirror.xiaohongshu.comment.biz.server;

import com.mirror.framework.common.response.PageResponse;
import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.comment.biz.model.vo.FindCommentItemRspVO;
import com.mirror.xiaohongshu.comment.biz.model.vo.FindCommentPageListReqVO;
import com.mirror.xiaohongshu.comment.biz.model.vo.PublishCommentReqVO;
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

    /**
     * 评论列表分页查询
     * @param findCommentPageListReqVO
     * @return
     */
    PageResponse<FindCommentItemRspVO> findCommentPageList(FindCommentPageListReqVO findCommentPageListReqVO);


}