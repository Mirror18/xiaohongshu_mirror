package com.mirror.xiaohongshu.comment.biz.server.impl;

import com.google.common.base.Preconditions;
import com.mirror.framework.biz.context.holder.LoginUserContextHolder;
import com.mirror.framework.common.response.Response;
import com.mirror.framework.common.util.JsonUtils;
import com.mirror.xiaohongshu.comment.biz.constant.MQConstants;
import com.mirror.xiaohongshu.comment.biz.model.dto.PublishCommentMqDTO;
import com.mirror.xiaohongshu.comment.biz.model.vo.PublishCommentReqVO;
import com.mirror.xiaohongshu.comment.biz.retry.SendMqRetryHelper;
import com.mirror.xiaohongshu.comment.biz.server.CommentService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @Auther: mirror
 * @Date: 2025/2/19 12:55
 * @Description:
 */
@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Resource
    private SendMqRetryHelper sendMqRetryHelper;
    /**
     * 发布评论
     *
     * @param publishCommentReqVO
     * @return
     */
    @Override
    public Response<?> publishComment(PublishCommentReqVO publishCommentReqVO) {
        // 评论正文
        String content = publishCommentReqVO.getContent();
        // 附近图片
        String imageUrl = publishCommentReqVO.getImageUrl();

        // 评论内容和图片不能同时为空
        Preconditions.checkArgument(StringUtils.isNotBlank(content) || StringUtils.isNotBlank(imageUrl),
                "评论正文和图片不能同时为空");

        // 发布者 ID
        Long creatorId = LoginUserContextHolder.getUserId();

        // 发送 MQ
        // 构建消息体 DTO
        PublishCommentMqDTO publishCommentMqDTO = PublishCommentMqDTO.builder()
                .noteId(publishCommentReqVO.getNoteId())
                .content(content)
                .imageUrl(imageUrl)
                .replyCommentId(publishCommentReqVO.getReplyCommentId())
                .createTime(LocalDateTime.now())
                .creatorId(creatorId)
                .build();

        // 发送 MQ (包含重试机制)
        sendMqRetryHelper.asyncSend(MQConstants.TOPIC_PUBLISH_COMMENT, JsonUtils.toJsonString(publishCommentMqDTO));

        return Response.success();
    }
}
