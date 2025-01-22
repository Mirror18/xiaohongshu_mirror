package com.mirror.xiaohongshu.auth.controller;

import com.mirror.framework.biz.operationlog.aspect.ApiOperationLog;
import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.auth.model.vo.user.UserLoginReqVO;
import com.mirror.xiaohongshu.auth.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: mirror
 * @Date: 2025/1/15 11:58
 * @Description:
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    @ApiOperationLog(description = "用户登录/注册")
    public Response<String> loginAndRegister(@Validated @RequestBody UserLoginReqVO userLoginReqVO) {
        return userService.loginAndRegister(userLoginReqVO);
    }


    @PostMapping("/logout")
    @ApiOperationLog(description = "账号登出")
    public Response<?> logout() {
        return userService.logout();
    }
}