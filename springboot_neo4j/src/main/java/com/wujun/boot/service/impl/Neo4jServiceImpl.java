package com.wujun.boot.service.impl;

import com.wujun.boot.dao.UserRepository;
import com.wujun.boot.entity.UserNode;
import com.wujun.boot.service.Neo4jService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Jun.Wu
 * @Date: 2019-10-28 09:17
 * @Description:
 */
@Service
public class Neo4jServiceImpl implements Neo4jService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public int addUser(UserNode userNode) {
        userRepository.addUserNodeList(userNode.getNodeId(), userNode.getUserId(), userNode.getName(), userNode.getAge());
        return 1;
    }

    @Override
    public List<UserNode> getUserNodeList() {
        return userRepository.getUserNodeList();
    }

    @Override
    public void deleteAllUserNodes() {
        userRepository.deleteAllUserNodes();
    }
}
