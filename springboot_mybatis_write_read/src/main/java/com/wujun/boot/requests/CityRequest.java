package com.wujun.boot.requests;

/**
 * @author wujun
 * @description
 * @date 18/1/11.
 */
public class CityRequest extends PageRequest {

    private String cityName;

    private Integer provinceId;

    private String description;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
