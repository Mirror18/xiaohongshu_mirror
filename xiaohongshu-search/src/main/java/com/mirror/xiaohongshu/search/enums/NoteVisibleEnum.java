package com.mirror.xiaohongshu.search.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: mirror
 * @Date: 2025/2/8 17:42
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum NoteVisibleEnum {

    PUBLIC(0), // 公开，所有人可见
    PRIVATE(1); // 仅自己可见

    private final Integer code;

}