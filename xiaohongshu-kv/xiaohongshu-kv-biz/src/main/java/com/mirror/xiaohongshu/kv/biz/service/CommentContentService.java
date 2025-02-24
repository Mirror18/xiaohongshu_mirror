package com.mirror.xiaohongshu.kv.biz.service;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.kv.dto.req.BatchAddCommentContentReqDTO;
import com.mirror.xiaohongshu.kv.dto.req.BatchFindCommentContentReqDTO;

/**
 * @Auther: mirror
 * @Date: 2025/2/20 07:17
 * @Description:
 */
public interface CommentContentService {


    /**
     * 批量添加评论内容
     * @param batchAddCommentContentReqDTO
     * @return
     */
    Response<?> batchAddCommentContent(BatchAddCommentContentReqDTO batchAddCommentContentReqDTO);

    /**
     * 批量查询评论内容
     * @param batchFindCommentContentReqDTO
     * @return
     */
    Response<?> batchFindCommentContent(BatchFindCommentContentReqDTO batchFindCommentContentReqDTO);


}