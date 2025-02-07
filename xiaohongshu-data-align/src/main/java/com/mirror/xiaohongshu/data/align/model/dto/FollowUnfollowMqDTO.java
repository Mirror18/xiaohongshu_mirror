package com.mirror.xiaohongshu.data.align.model.dto;

import lombok.*;


/**
 * @Auther: mirror
 * @Date: 2025/2/7 14:55
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FollowUnfollowMqDTO {

    /**
     * 原用户
     */
    private Long userId;

    /**
     * 目标用户
     */
    private Long targetUserId;

    /**
     * 1:关注 0:取关
     */
    private Integer type;

}
