package com.wujun.entities;

/**
 * @author wujun
 * @description
 * @date 18/1/9.
 */
public class User {
    private Long id;

    private String name;

    private Integer sex;

    public User() {
    }

    public User(Long id, String name, Integer sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
