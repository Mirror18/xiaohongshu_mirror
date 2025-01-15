package com.mirror.xiaohongshu.auth.domain.dataobject;

import com.mirror.framework.common.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author mirror
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PermissionDO {
    private Long id;

    private Long parentId;

    private String name;

    private Byte type;

    private String menuUrl;

    private String menuIcon;

    private Integer sort;

    private String permissionKey;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean isDeleted;


}