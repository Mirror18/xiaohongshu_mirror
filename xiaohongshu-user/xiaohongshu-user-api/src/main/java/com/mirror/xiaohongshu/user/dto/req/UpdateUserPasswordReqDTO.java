package com.mirror.xiaohongshu.user.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * @Auther: mirror
 * @Date: 2025/1/26 08:35
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserPasswordReqDTO {

    @NotBlank(message = "密码不能为空")
    private String encodePassword;

}