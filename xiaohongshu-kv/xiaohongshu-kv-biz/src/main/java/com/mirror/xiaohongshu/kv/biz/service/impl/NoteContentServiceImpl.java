package com.mirror.xiaohongshu.kv.biz.service.impl;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.kv.biz.domain.dataobject.NoteContentDO;
import com.mirror.xiaohongshu.kv.biz.domain.repository.NoteContentRepository;
import com.mirror.xiaohongshu.kv.biz.service.NoteContentService;
import com.mirror.xiaohongshu.kv.dto.req.AddNoteContentReqDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Auther: mirror
 * @Date: 2025/1/27 09:26
 * @Description:
 */
@Service
@Slf4j
public class NoteContentServiceImpl implements NoteContentService {

    @Resource
    private NoteContentRepository noteContentRepository;


    @Override
    public Response<?> addNoteContent(AddNoteContentReqDTO addNoteContentReqDTO) {
        // 笔记 ID
        Long noteId = addNoteContentReqDTO.getNoteId();
        // 笔记内容
        String content = addNoteContentReqDTO.getContent();

        // 构建数据库 DO 实体类
        NoteContentDO nodeContent = NoteContentDO.builder()
                .id(UUID.randomUUID()) // TODO: 暂时用 UUID, 目的是为了下一章讲解压测，不用动态传笔记 ID。后续改为笔记服务传过来的笔记 ID
                .content(content)
                .build();

        // 插入数据
        noteContentRepository.save(nodeContent);

        return Response.success();
    }
}