package com.mirror.xiaohongshu.kv.biz.controller;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.kv.biz.service.NoteContentService;
import com.mirror.xiaohongshu.kv.dto.req.AddNoteContentReqDTO;
import com.mirror.xiaohongshu.kv.dto.req.DeleteNoteContentReqDTO;
import com.mirror.xiaohongshu.kv.dto.req.FindNoteContentReqDTO;
import com.mirror.xiaohongshu.kv.dto.rsp.FindNoteContentRspDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: mirror
 * @Date: 2025/1/27 09:28
 * @Description:
 */
@RestController
@RequestMapping("/kv")
@Slf4j
public class NoteContentController {

    @Resource
    private NoteContentService noteContentService;

    @PostMapping(value = "/note/content/add")
    public Response<?> addNoteContent(@Validated @RequestBody AddNoteContentReqDTO addNoteContentReqDTO) {
        return noteContentService.addNoteContent(addNoteContentReqDTO);
    }

    @PostMapping(value = "/note/content/find")
    public Response<FindNoteContentRspDTO> findNoteContent(@Validated @RequestBody FindNoteContentReqDTO findNoteContentReqDTO) {
        return noteContentService.findNoteContent(findNoteContentReqDTO);
    }


    @PostMapping(value = "/note/content/delete")
    public Response<?> deleteNoteContent(@Validated @RequestBody DeleteNoteContentReqDTO deleteNoteContentReqDTO) {
        return noteContentService.deleteNoteContent(deleteNoteContentReqDTO);
    }

}
