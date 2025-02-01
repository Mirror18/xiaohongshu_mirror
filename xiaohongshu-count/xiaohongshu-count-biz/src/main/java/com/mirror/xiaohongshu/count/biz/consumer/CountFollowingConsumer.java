package com.mirror.xiaohongshu.count.biz.consumer;

import com.mirror.xiaohongshu.count.biz.constant.MQConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: mirror
 * @Date: 2025/2/2 05:12
 * @Description:
 */
@Component
@RocketMQMessageListener(consumerGroup = "xiaohongshu_group_" + MQConstants.TOPIC_COUNT_FOLLOWING, // Group 组
        topic = MQConstants.TOPIC_COUNT_FOLLOWING // 主题 Topic
)
@Slf4j
public class CountFollowingConsumer implements RocketMQListener<String> { // TODO: Message


    @Override
    public void onMessage(String body) {
        log.info("## 消费到了 MQ 【计数: 关注数】, {}...", body);
    }


}