package com.mirror.xiaohongshu.user.relation.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: mirror
 * @Date: 2025/2/2 05:03
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum FollowUnfollowTypeEnum {
    // 关注
    FOLLOW(1),
    // 取关
    UNFOLLOW(0),
    ;

    private final Integer code;

}