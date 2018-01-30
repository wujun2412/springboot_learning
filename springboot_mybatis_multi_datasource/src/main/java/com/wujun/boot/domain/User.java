package com.wujun.boot.domain;

public class User {
    /**
     * 用户编号
     */
    private Integer id;

    /**
     * city_id
     */
    private Integer cityId;

    /**
     * 用户名
     */
    private String name;

    /**
     * 男
     */
    private Integer sex;

    /**
     * 获取 [USER] 的属性 用户编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置[USER]的属性用户编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 [USER] 的属性 city_id
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * 设置[USER]的属性city_id
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取 [USER] 的属性 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置[USER]的属性用户名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取 [USER] 的属性 男
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置[USER]的属性男
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }
}