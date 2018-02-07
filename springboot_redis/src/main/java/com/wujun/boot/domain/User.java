package com.wujun.boot.domain;

import java.io.Serializable;

/**
 * @author wujun
 * @description
 * @date 18/2/1.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -9056964428535843303L;

    private String userName;

    private Integer age;

    public User() {
    }

    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
