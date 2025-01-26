package com.mirror.xiaohongshu.user.dto.resp;

import lombok.*;

/**
 * @Auther: mirror
 * @Date: 2025/1/26 08:23
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindUserByPhoneRspDTO {

    private Long id;

    private String password;

}
