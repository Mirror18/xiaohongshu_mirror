package com.mirror.xiaohongshu.data.align.domain.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: mirror
 * @Date: 2025/2/7 15:41
 * @Description:
 */
public interface DeleteMapper {

    /**
     * 日增量表：关注数计数变更 - 批量删除
     * @param userIds
     */
    void batchDeleteDataAlignFollowingCountTempTable(@Param("tableNameSuffix") String tableNameSuffix,
                                                     @Param("userIds") List<Long> userIds);
}