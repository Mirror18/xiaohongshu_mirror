package com.mirror.xiaohongshu.auth.model.vo.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: mirror
 * @Date: 2025/1/24 04:47
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePasswordReqVO {

    @NotBlank(message = "新密码不能为空")
    private String newPassword;

}