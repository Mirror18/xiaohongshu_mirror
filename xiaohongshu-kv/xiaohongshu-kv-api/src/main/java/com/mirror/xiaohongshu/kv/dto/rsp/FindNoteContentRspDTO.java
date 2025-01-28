package com.mirror.xiaohongshu.kv.dto.rsp;

import lombok.*;

import java.util.UUID;

/**
 * @Auther: mirror
 * @Date: 2025/1/27 09:51
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindNoteContentRspDTO {


    /**
     * 笔记内容 UUID
     */
    private UUID uuid;

    /**
     * 笔记内容
     */
    private String content;

}
