package com.wujun.boot.controller;

import com.wujun.boot.entity.UserNode;
import com.wujun.boot.service.Neo4jService;
import com.wujun.common.responses.ApiResult;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @Author: Jun.Wu
 * @Date: 2019-10-28 09:28
 * @Description:
 */
@RestController
public class Neo4jController {

    @Autowired
    private Neo4jService neo4jService;

    @ApiOperation(value="添加用户节点", notes="添加用户节点")
    @RequestMapping(path = "/addUserNode", method = RequestMethod.GET)
    public ApiResult addUserNode(){
        int total = 100;
        for (int i = 0; i < total; i++) {
            UserNode userNode = new UserNode();
            userNode.setAge(RandomUtils.nextInt(15,40));
            userNode.setName("lisan" + RandomUtils.nextInt(1,1000));
            userNode.setUserId(UUID.randomUUID().toString());
            userNode.setNodeId(RandomUtils.nextLong(1L,999L));
            neo4jService.addUser(userNode);
        }
        return ApiResult.SUCCESS();
    }

    @ApiOperation(value="获取用户节点", notes="获取用户节点")
    @RequestMapping(path = "/getUserNodeList", method = RequestMethod.GET)
    public ApiResult<List<UserNode>> getUserNodeList(){
        List<UserNode> userNodeList = neo4jService.getUserNodeList();
        return ApiResult.success(userNodeList);
    }

    @ApiOperation(value="删除所有用户节点", notes="删除所有用户节点")
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public ApiResult deleteAllUserNodes(){
        neo4jService.deleteAllUserNodes();
        return ApiResult.SUCCESS();
    }


}
