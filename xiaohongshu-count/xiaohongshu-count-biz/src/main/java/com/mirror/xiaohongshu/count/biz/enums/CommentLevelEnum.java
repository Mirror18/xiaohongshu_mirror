package com.mirror.xiaohongshu.count.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: mirror
 * @Date: 2025/2/25 01:46
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum CommentLevelEnum {
    // 一级评论
    ONE(1),
    // 二级评论
    TWO(2),
    ;

    private final Integer code;

}