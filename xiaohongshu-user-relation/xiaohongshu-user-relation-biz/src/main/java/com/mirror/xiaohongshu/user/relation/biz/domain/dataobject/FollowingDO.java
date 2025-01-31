package com.mirror.xiaohongshu.user.relation.biz.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FollowingDO {
    private Long id;

    private Long userId;

    private Long followingUserId;

    private Date createTime;

}