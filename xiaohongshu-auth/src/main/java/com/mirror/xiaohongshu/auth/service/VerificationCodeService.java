package com.mirror.xiaohongshu.auth.service;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.auth.model.vo.veriticationcode.SendVerificationCodeReqVO;

/**
 * @Auther: mirror
 * @Date: 2025/1/15 03:46
 * @Description:
 */
public interface VerificationCodeService {

    /**
     * 发送短信验证码
     *
     * @param sendVerificationCodeReqVO
     * @return
     */
    Response<?> send(SendVerificationCodeReqVO sendVerificationCodeReqVO);
}