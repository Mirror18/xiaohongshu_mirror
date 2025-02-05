package com.mirror.xiaohongshu.count.biz.constant;

/**
 * @Auther: mirror
 * @Date: 2025/2/2 05:11
 * @Description:
 */
public interface MQConstants {

    /**
     * Topic: 关注数计数
     */
    String TOPIC_COUNT_FOLLOWING = "CountFollowingTopic";

    /**
     * Topic: 粉丝数计数
     */
    String TOPIC_COUNT_FANS = "CountFansTopic";

    /**
     * Topic: 粉丝数计数入库
     */
    String TOPIC_COUNT_FANS_2_DB = "CountFans2DBTopic";
    /**
     * Topic: 粉丝数计数入库
     */
    String TOPIC_COUNT_FOLLOWING_2_DB = "CountFollowing2DBTopic";

    /**
     * Topic: 计数 - 笔记点赞数
     */
    String TOPIC_COUNT_NOTE_LIKE = "CountNoteLikeTopic";

    /**
     * Topic: 计数 - 笔记点赞数落库
     */
    String TOPIC_COUNT_NOTE_LIKE_2_DB = "CountNoteLike2DBTTopic";

    /**
     * Topic: 计数 - 笔记收藏数
     */
    String TOPIC_COUNT_NOTE_COLLECT = "CountNoteCollectTopic";


    /**
     * Topic: 计数 - 笔记收藏数落库
     */
    String TOPIC_COUNT_NOTE_COLLECT_2_DB = "CountNoteCollect2DBTTopic";


}