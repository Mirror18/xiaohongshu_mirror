package com.mirror.xiaohongshu.comment.biz.rpc;

import com.google.common.collect.Lists;
import com.mirror.framework.common.constant.DateConstants;
import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.comment.biz.model.bo.CommentBO;
import com.mirror.xiaohongshu.kv.api.KeyValueFeignApi;
import com.mirror.xiaohongshu.kv.dto.req.BatchAddCommentContentReqDTO;
import com.mirror.xiaohongshu.kv.dto.req.CommentContentReqDTO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: mirror
 * @Date: 2025/2/22 11:34
 * @Description:
 */
@Component
public class KeyValueRpcService {

    @Resource
    private KeyValueFeignApi keyValueFeignApi;

    /**
     * 批量存储评论内容
     * @param commentBOS
     * @return
     */
    public boolean batchSaveCommentContent(List<CommentBO> commentBOS) {
        List<CommentContentReqDTO> comments = Lists.newArrayList();

        // BO 转 DTO
        commentBOS.forEach(commentBO -> {
            CommentContentReqDTO commentContentReqDTO = CommentContentReqDTO.builder()
                    .noteId(commentBO.getNoteId())
                    .content(commentBO.getContent())
                    .contentId(commentBO.getContentUuid())
                    .yearMonth(commentBO.getCreateTime().format(DateConstants.DATE_FORMAT_Y_M))
                    .build();
            comments.add(commentContentReqDTO);
        });

        // 构建接口入参实体类
        BatchAddCommentContentReqDTO batchAddCommentContentReqDTO = BatchAddCommentContentReqDTO.builder()
                .comments(comments)
                .build();

        // 调用 KV 存储服务
        Response<?> response = keyValueFeignApi.batchAddCommentContent(batchAddCommentContentReqDTO);

        // 若返参中 success 为 false, 则主动抛出异常，以便调用层回滚事务
        if (!response.isSuccess()) {
            throw new RuntimeException("批量保存评论内容失败");
        }

        return true;
    }

}