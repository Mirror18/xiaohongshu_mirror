package com.mirror.xiaohongshu.kv.biz.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * @Auther: mirror
 * @Date: 2025/2/20 07:16
 * @Description:
 */
@Table("comment_content")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentContentDO {

    @PrimaryKey
    private CommentContentPrimaryKey primaryKey;

    private String content;
}