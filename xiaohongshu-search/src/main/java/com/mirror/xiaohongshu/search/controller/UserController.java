package com.mirror.xiaohongshu.search.controller;

import com.mirror.framework.biz.operationlog.aspect.ApiOperationLog;
import com.mirror.framework.common.response.PageResponse;
import com.mirror.xiaohongshu.search.model.vo.SearchUserReqVO;
import com.mirror.xiaohongshu.search.model.vo.SearchUserRspVO;
import com.mirror.xiaohongshu.search.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: mirror
 * @Date: 2025/2/8 11:35
 * @Description:
 */
@RestController
@RequestMapping("/search")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/user")
    @ApiOperationLog(description = "搜索用户")
    public PageResponse<SearchUserRspVO> searchUser(@RequestBody @Validated SearchUserReqVO searchUserReqVO) {
        return userService.searchUser(searchUserReqVO);
    }


}