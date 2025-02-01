package com.mirror.xiaohongshu.user.relation.biz.controller;

import com.mirror.framework.biz.operationlog.aspect.ApiOperationLog;
import com.mirror.framework.common.response.PageResponse;
import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.user.relation.biz.model.vo.FindFollowingListReqVO;
import com.mirror.xiaohongshu.user.relation.biz.model.vo.FindFollowingUserRspVO;
import com.mirror.xiaohongshu.user.relation.biz.model.vo.FollowUserReqVO;
import com.mirror.xiaohongshu.user.relation.biz.model.vo.UnfollowUserReqVO;
import com.mirror.xiaohongshu.user.relation.biz.service.RelationService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @Auther: mirror
 * @Date: 2025/1/31 16:50
 * @Description:
 */
@RestController
@RequestMapping("/relation")
@Slf4j
public class RelationController {

    @Resource
    private RelationService relationService;

    @PostMapping("/follow")
    @ApiOperationLog(description = "关注用户")
    public Response<?> follow(@Validated @RequestBody FollowUserReqVO followUserReqVO) {
        return relationService.follow(followUserReqVO);
    }

    @PostMapping("/unfollow")
    @ApiOperationLog(description = "取关用户")
    public Response<?> unfollow(@Validated @RequestBody UnfollowUserReqVO unfollowUserReqVO) {
        return relationService.unfollow(unfollowUserReqVO);
    }

    @PostMapping("/following/list")
    @ApiOperationLog(description = "查询用户关注列表")
    public PageResponse<FindFollowingUserRspVO> findFollowingList(@Validated @RequestBody FindFollowingListReqVO findFollowingListReqVO) {
        return relationService.findFollowingList(findFollowingListReqVO);
    }
}