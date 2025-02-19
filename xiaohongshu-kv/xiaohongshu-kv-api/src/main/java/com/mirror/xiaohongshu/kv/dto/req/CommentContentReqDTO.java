package com.mirror.xiaohongshu.kv.dto.req;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: mirror
 * @Date: 2025/2/20 07:15
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentContentReqDTO {

    @NotNull(message = "评论 ID 不能为空")
    private Long noteId;

    @NotBlank(message = "发布年月不能为空")
    private String yearMonth;

    @NotBlank(message = "评论正文 ID 不能为空")
    private String contentId;

    @NotBlank(message = "评论正文不能为空")
    private String content;

}