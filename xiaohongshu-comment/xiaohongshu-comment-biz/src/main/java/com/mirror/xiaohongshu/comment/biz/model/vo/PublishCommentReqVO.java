package com.mirror.xiaohongshu.comment.biz.model.vo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: mirror
 * @Date: 2025/2/19 12:51
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublishCommentReqVO {

    @NotNull(message = "笔记 ID 不能为空")
    private Long noteId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论图片链接
     */
    private String imageUrl;

    /**
     * 回复的哪个评论（评论 ID）
     */
    private Long replyCommentId;

}
