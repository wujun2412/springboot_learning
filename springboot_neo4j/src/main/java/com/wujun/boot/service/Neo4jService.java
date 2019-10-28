package com.wujun.boot.service;

import com.wujun.boot.entity.UserNode;

import java.util.List;

/**
 * @Author: Jun.Wu
 * @Date: 2019-10-28 09:16
 * @Description:
 */
public interface Neo4jService {

    int addUser(UserNode userNode);

    List<UserNode> getUserNodeList();

    void deleteAllUserNodes();

}
