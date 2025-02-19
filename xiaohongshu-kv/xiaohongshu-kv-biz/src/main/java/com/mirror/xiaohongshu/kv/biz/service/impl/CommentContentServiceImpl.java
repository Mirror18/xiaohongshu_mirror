package com.mirror.xiaohongshu.kv.biz.service.impl;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.kv.biz.domain.dataobject.CommentContentDO;
import com.mirror.xiaohongshu.kv.biz.domain.dataobject.CommentContentPrimaryKey;
import com.mirror.xiaohongshu.kv.biz.service.CommentContentService;
import com.mirror.xiaohongshu.kv.dto.req.BatchAddCommentContentReqDTO;
import com.mirror.xiaohongshu.kv.dto.req.CommentContentReqDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Auther: mirror
 * @Date: 2025/2/20 07:18
 * @Description:
 */
@Service
@Slf4j
public class CommentContentServiceImpl implements CommentContentService {

    @Resource
    private CassandraTemplate cassandraTemplate;

    /**
     * 批量添加评论内容
     *
     * @param batchAddCommentContentReqDTO
     * @return
     */
    @Override
    public Response<?> batchAddCommentContent(BatchAddCommentContentReqDTO batchAddCommentContentReqDTO) {
        List<CommentContentReqDTO> comments = batchAddCommentContentReqDTO.getComments();

        // DTO 转 DO
        List<CommentContentDO> contentDOS = comments.stream()
                .map(commentContentReqDTO -> {
                    // 构建主键类
                    CommentContentPrimaryKey commentContentPrimaryKey = CommentContentPrimaryKey.builder()
                            .noteId(commentContentReqDTO.getNoteId())
                            .yearMonth(commentContentReqDTO.getYearMonth())
                            .contentId(UUID.fromString(commentContentReqDTO.getContentId()))
                            .build();

                    // DO 实体类
                    CommentContentDO commentContentDO = CommentContentDO.builder()
                            .primaryKey(commentContentPrimaryKey)
                            .content(commentContentReqDTO.getContent())
                            .build();

                    return commentContentDO;
                }).toList();

        // 批量插入
        cassandraTemplate.batchOps()
                .insert(contentDOS)
                .execute();

        return Response.success();
    }
}
