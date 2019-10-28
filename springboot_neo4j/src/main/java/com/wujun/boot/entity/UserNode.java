package com.wujun.boot.entity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * @Author: Jun.Wu
 * @Date: 2019-10-25 17:04
 * @Description:
 */
@NodeEntity(label = "User")
public class UserNode {

    @GraphId
    private Long nodeId;

    @Property(name = "userId")
    private String userId;

    @Property(name = "name")
    private String name;

    @Property(name = "age")
    private int age;

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
