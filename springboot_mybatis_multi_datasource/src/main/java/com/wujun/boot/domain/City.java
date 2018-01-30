package com.wujun.boot.domain;

public class City {
    /**
     * 城市编号
     */
    private Integer id;

    /**
     * 省份编号
     */
    private Integer provinceId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;

    /**
     * 获取 [CITY] 的属性 城市编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置[CITY]的属性城市编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 [CITY] 的属性 省份编号
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     * 设置[CITY]的属性省份编号
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 获取 [CITY] 的属性 城市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置[CITY]的属性城市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * 获取 [CITY] 的属性 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置[CITY]的属性描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}