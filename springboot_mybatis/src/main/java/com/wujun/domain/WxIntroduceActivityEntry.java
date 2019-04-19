package com.wujun.domain;

import java.util.Date;

public class WxIntroduceActivityEntry {
    /**
     * 主键
     */
    private Long entryId;

    /**
     * 推荐 ID
     */
    private Long recommendId;

    /**
     * 转介绍活动ID
     */
    private Long activityId;

    /**
     * 留咨姓名
     */
    private String name;

    /**
     * 留资电话
     */
    private String mobile;

    /**
     * 留资时间
     */
    private Date entryTime;

    /**
     * 公司ID
     */
    private Long companyId;

    /**
     * 经销商ID
     */
    private Long dealerId;

    /**
     * 经销商名称
     */
    private String dealerName;

    /**
     * 国家
     */
    private Long country;

    /**
     * 省份
     */
    private Long province;

    /**
     * 城市
     */
    private Long city;

    /**
     * 区县
     */
    private Long county;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 创建者
     */
    private Long createdBy;

    /**
     * 创建者姓名
     */
    private String createdName;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新者
     */
    private Long updatedBy;

    /**
     * 更新者姓名
     */
    private String updatedName;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 数据版本
     */
    private Integer version;

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 主键
     */
    public Long getEntryId() {
        return entryId;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性主键
     */
    public void setEntryId(Long entryId) {
        this.entryId = entryId;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 推荐 ID
     */
    public Long getRecommendId() {
        return recommendId;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性推荐 ID
     */
    public void setRecommendId(Long recommendId) {
        this.recommendId = recommendId;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 转介绍活动ID
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性转介绍活动ID
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 留咨姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性留咨姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 留资电话
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性留资电话
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 留资时间
     */
    public Date getEntryTime() {
        return entryTime;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性留资时间
     */
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 公司ID
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性公司ID
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 经销商ID
     */
    public Long getDealerId() {
        return dealerId;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性经销商ID
     */
    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 经销商名称
     */
    public String getDealerName() {
        return dealerName;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性经销商名称
     */
    public void setDealerName(String dealerName) {
        this.dealerName = dealerName == null ? null : dealerName.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 国家
     */
    public Long getCountry() {
        return country;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性国家
     */
    public void setCountry(Long country) {
        this.country = country;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 省份
     */
    public Long getProvince() {
        return province;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性省份
     */
    public void setProvince(Long province) {
        this.province = province;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 城市
     */
    public Long getCity() {
        return city;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性城市
     */
    public void setCity(Long city) {
        this.city = city;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 区县
     */
    public Long getCounty() {
        return county;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性区县
     */
    public void setCounty(Long county) {
        this.county = county;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 创建者
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性创建者
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 创建者姓名
     */
    public String getCreatedName() {
        return createdName;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性创建者姓名
     */
    public void setCreatedName(String createdName) {
        this.createdName = createdName == null ? null : createdName.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 更新者
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性更新者
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 更新者姓名
     */
    public String getUpdatedName() {
        return updatedName;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性更新者姓名
     */
    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName == null ? null : updatedName.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ENTRY] 的属性 数据版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ENTRY]的属性数据版本
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}