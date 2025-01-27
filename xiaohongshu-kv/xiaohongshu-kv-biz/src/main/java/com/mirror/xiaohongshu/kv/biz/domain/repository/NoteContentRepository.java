package com.mirror.xiaohongshu.kv.biz.domain.repository;

import com.mirror.xiaohongshu.kv.biz.domain.dataobject.NoteContentDO;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

/**
 * @Auther: mirror
 * @Date: 2025/1/27 09:10
 * @Description:
 */
public interface NoteContentRepository extends CassandraRepository<NoteContentDO, UUID> {

}