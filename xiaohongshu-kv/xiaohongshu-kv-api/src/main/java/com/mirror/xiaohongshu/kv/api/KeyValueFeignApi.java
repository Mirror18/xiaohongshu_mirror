package com.mirror.xiaohongshu.kv.api;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.kv.constant.ApiConstants;
import com.mirror.xiaohongshu.kv.dto.req.AddNoteContentReqDTO;
import com.mirror.xiaohongshu.kv.dto.req.DeleteNoteContentReqDTO;
import com.mirror.xiaohongshu.kv.dto.req.FindNoteContentReqDTO;
import com.mirror.xiaohongshu.kv.dto.rsp.FindNoteContentRspDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Auther: mirror
 * @Date: 2025/1/27 09:30
 * @Description:
 */
@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface KeyValueFeignApi {

    String PREFIX = "/kv";

    @PostMapping(value = PREFIX + "/note/content/add")
    Response<?> addNoteContent(@RequestBody AddNoteContentReqDTO addNoteContentReqDTO);

    @PostMapping(value = PREFIX + "/note/content/find")
    Response<FindNoteContentRspDTO> findNoteContent(@RequestBody FindNoteContentReqDTO findNoteContentReqDTO);

    @PostMapping(value = PREFIX + "/note/content/delete")
    Response<?> deleteNoteContent(@RequestBody DeleteNoteContentReqDTO deleteNoteContentReqDTO);
}