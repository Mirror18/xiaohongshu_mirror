package com.mirror.xiaohongshu.user.relation.biz.constant;

/**
 * @Auther: mirror
 * @Date: 2025/2/1 13:29
 * @Description:
 */
public interface MQConstants {

    /**
     * Topic: 关注、取关共用一个
     */
    String TOPIC_FOLLOW_OR_UNFOLLOW = "FollowUnfollowTopic";

    /**
     * 关注标签
     */
    String TAG_FOLLOW = "Follow";

    /**
     * 取关标签
     */
    String TAG_UNFOLLOW = "Unfollow";
}