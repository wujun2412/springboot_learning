package com.wujun.boot.domain;

import java.io.Serializable;

/**
 * @author wujun
 * @description
 * @date 19/5/10.
 */
public class User implements Serializable{

    private static final long serialVersionUID = 7305556442274584285L;
    private String userName;
    private Integer age;

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

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
