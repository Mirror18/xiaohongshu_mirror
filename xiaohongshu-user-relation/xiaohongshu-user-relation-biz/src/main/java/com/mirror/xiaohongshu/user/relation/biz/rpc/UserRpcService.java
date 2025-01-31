package com.mirror.xiaohongshu.user.relation.biz.rpc;

import com.mirror.framework.common.response.Response;
import com.mirror.xiaohongshu.user.api.UserFeignApi;
import com.mirror.xiaohongshu.user.dto.req.FindUserByIdReqDTO;
import com.mirror.xiaohongshu.user.dto.resp.FindUserByIdRspDTO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Auther: mirror
 * @Date: 2025/1/31 16:47
 * @Description:
 */
@Component
public class UserRpcService {

    @Resource
    private UserFeignApi userFeignApi;

    /**
     * 根据用户 ID 查询
     *
     * @param userId
     * @return
     */
    public FindUserByIdRspDTO findById(Long userId) {
        FindUserByIdReqDTO findUserByIdReqDTO = new FindUserByIdReqDTO();
        findUserByIdReqDTO.setId(userId);

        Response<FindUserByIdRspDTO> response = userFeignApi.findById(findUserByIdReqDTO);

        if (!response.isSuccess() || Objects.isNull(response.getData())) {
            return null;
        }

        return response.getData();
    }


}