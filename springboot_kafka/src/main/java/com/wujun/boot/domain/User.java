package com.wujun.boot.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wujun
 * @description
 * @date 19/5/10.
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 7305556442274584285L;
    private String userName;
    private Integer age;

    public User(String userName, Integer age) {
        this.userName = userName;
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
