package com.mirror.xiaohongshu.comment.biz.controller;

import com.mirror.framework.biz.operationlog.aspect.ApiOperationLog;
import com.mirror.framework.common.response.PageResponse;
import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.comment.biz.model.vo.FindCommentItemRspVO;
import com.mirror.xiaohongshu.comment.biz.model.vo.FindCommentPageListReqVO;
import com.mirror.xiaohongshu.comment.biz.model.vo.PublishCommentReqVO;
import com.mirror.xiaohongshu.comment.biz.server.CommentService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: mirror
 * @Date: 2025/2/19 13:04
 * @Description:
 */
@RestController
@RequestMapping("/comment")
@Slf4j
public class CommentController {

    @Resource
    private CommentService commentService;

    @PostMapping("/publish")
    @ApiOperationLog(description = "发布评论")
    public Response<?> publishComment(@Validated @RequestBody PublishCommentReqVO publishCommentReqVO) {
        return commentService.publishComment(publishCommentReqVO);
    }


    @PostMapping("/list")
    @ApiOperationLog(description = "评论分页查询")
    public PageResponse<FindCommentItemRspVO> findCommentPageList(@Validated @RequestBody FindCommentPageListReqVO findCommentPageListReqVO) {
        return commentService.findCommentPageList(findCommentPageListReqVO);
    }

}