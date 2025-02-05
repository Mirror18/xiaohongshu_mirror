package com.mirror.xiaohongshu.count.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @Auther: mirror
 * @Date: 2025/2/5 15:07
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum LikeUnlikeNoteTypeEnum {
    // 点赞
    LIKE(1),
    // 取消点赞
    UNLIKE(0),
    ;

    private final Integer code;

    public static LikeUnlikeNoteTypeEnum valueOf(Integer code) {
        for (LikeUnlikeNoteTypeEnum likeUnlikeNoteTypeEnum : LikeUnlikeNoteTypeEnum.values()) {
            if (Objects.equals(code, likeUnlikeNoteTypeEnum.getCode())) {
                return likeUnlikeNoteTypeEnum;
            }
        }
        return null;
    }

}