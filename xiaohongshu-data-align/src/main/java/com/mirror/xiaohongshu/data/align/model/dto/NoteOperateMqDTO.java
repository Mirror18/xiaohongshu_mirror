package com.mirror.xiaohongshu.data.align.model.dto;


import lombok.*;


/**
 * @Auther: mirror
 * @Date: 2025/2/7 14:48
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteOperateMqDTO {

    /**
     * 笔记发布者 ID
     */
    private Long creatorId;

    /**
     * 笔记 ID
     */
    private Long noteId;

    /**
     * 操作类型： 0 - 笔记删除； 1：笔记发布；
     */
    private Integer type;

}