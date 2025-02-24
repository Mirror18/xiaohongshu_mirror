package com.mirror.xiaohongshu.kv.biz.domain.repository;

import com.mirror.xiaohongshu.kv.biz.domain.dataobject.CommentContentDO;
import com.mirror.xiaohongshu.kv.biz.domain.dataobject.CommentContentPrimaryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

/**
 * @Auther: mirror
 * @Date: 2025/2/25 03:33
 * @Description:
 */
public interface CommentContentRepository extends CassandraRepository<CommentContentDO, CommentContentPrimaryKey> {

    /**
     * 批量查询评论内容
     * @param noteId
     * @param yearMonths
     * @param contentIds
     * @return
     */
    List<CommentContentDO> findByPrimaryKeyNoteIdAndPrimaryKeyYearMonthInAndPrimaryKeyContentIdIn(
            Long noteId, List<String> yearMonths, List<UUID> contentIds
    );
}
