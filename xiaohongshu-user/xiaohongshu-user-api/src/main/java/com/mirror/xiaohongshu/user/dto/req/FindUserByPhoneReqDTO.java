package com.mirror.xiaohongshu.user.dto.req;

import com.mirror.framework.common.validator.PhoneNumber;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * @Auther: mirror
 * @Date: 2025/1/26 08:22
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindUserByPhoneReqDTO {

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @PhoneNumber
    private String phone;

}