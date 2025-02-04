package com.mirror.xiaohongshu.note.biz.model.vo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: mirror
 * @Date: 2025/2/4 12:39
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnlikeNoteReqVO {

    @NotNull(message = "笔记 ID 不能为空")
    private Long id;

}
