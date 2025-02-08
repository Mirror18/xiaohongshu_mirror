package com.mirror.xiaohongshu.search.domain.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * @Auther: mirror
 * @Date: 2025/2/8 17:30
 * @Description:
 */
public interface SelectMapper {

    /**
     * 查询笔记文档所需的全字段数据
     * @param noteId
     * @return
     */
    List<Map<String, Object>> selectEsNoteIndexData(@Param("noteId") long noteId);
}