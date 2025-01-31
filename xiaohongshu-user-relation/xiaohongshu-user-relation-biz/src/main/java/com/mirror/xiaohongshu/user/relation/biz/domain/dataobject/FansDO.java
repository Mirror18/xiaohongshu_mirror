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
public class FansDO {
    private Long id;

    private Long userId;

    private Long fansUserId;

    private Date createTime;

}