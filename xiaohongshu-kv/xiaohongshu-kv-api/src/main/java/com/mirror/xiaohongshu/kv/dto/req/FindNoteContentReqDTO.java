package com.mirror.xiaohongshu.kv.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * @Auther: mirror
 * @Date: 2025/1/27 09:50
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindNoteContentReqDTO {

    @NotBlank(message = "笔记 ID 不能为空")
    private String noteId;

}