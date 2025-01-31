package com.mirror.xiaohongshu.user.relation.biz.domain.mapper;

import com.mirror.xiaohongshu.user.relation.biz.domain.dataobject.FansDO;

public interface FansDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FansDO record);

    int insertSelective(FansDO record);

    FansDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FansDO record);

    int updateByPrimaryKey(FansDO record);
}