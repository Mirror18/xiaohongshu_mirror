package com.mirror.xiaohongshu.comment.biz.model.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Auther: mirror
 * @Date: 2025/2/20 13:52
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentBO {
    private Long id;

    private Long noteId;

    private Long userId;

    private String contentUuid;

    private String content;

    private Boolean isContentEmpty;

    private String imageUrl;

    private Integer level;

    private Long replyTotal;

    private Long likeTotal;

    private Long parentId;

    private Long replyCommentId;

    private Long replyUserId;

    private Boolean isTop;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}