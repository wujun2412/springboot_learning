package com.wujun.boot.domain;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author wujun
 * @description
 * @date 18/2/1.
 */
public class User implements Serializable{
    private static final long serialVersionUID = -9056964428535843303L;

    @Id
    private Long id;

    private String username;

    private Integer age;

    public User() {
    }

    public User(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
