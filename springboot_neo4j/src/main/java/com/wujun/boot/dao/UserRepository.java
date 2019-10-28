package com.wujun.boot.dao;

import com.wujun.boot.entity.UserNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Jun.Wu
 * @Date: 2019-10-25 17:18
 * @Description:
 */
@Component
public interface UserRepository extends GraphRepository<UserNode> {

    @Query("MATCH (n:User) RETURN n ")
    List<UserNode> getUserNodeList();

    @Query("create (n:User{nodeId:{nodeId},userId:{userId},name:{name},age:{age}}) return n ")
    List<UserNode> addUserNodeList(@Param("nodeId") Long nodeId, @Param("userId") String userId, @Param("name") String name, @Param("age") int age);

    @Query("MATCH (n:User) DELETE n")
    void deleteAllUserNodes();

}
