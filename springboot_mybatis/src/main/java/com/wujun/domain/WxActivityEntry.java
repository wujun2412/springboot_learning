package com.wujun.domain;

import java.util.Date;

public class WxActivityEntry {
    /**
     * 主键
     */
    private Long entryId;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 地区
     */
    private String region;

    /**
     * 电话
     */
    private String mobile;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 车型
     */
    private String model;

    /**
     * 性别 1.男 2.女
     */
    private Boolean sex;

    /**
     * 报名状态: 0:已申请 1.已通过 2.未通过
     */
    private Boolean status;

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
     * 获取 [WX_ACTIVITY_ENTRY] 的属性 主键
     */
    public Long getEntryId() {
        return entryId;
    }

    /**
     * 设置[WX_ACTIVITY_ENTRY]的属性主键
     */
    public void setEntryId(Long entryId) {
        this.entryId = entryId;
    }

    /**
     * 获取 [WX_ACTIVITY_ENTRY] 的属性 活动ID
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * 设置[WX_ACTIVITY_ENTRY]的属性活动ID
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 获取 [WX_ACTIVITY_ENTRY] 的属性 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置[WX_ACTIVITY_ENTRY]的属性姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取 [WX_ACTIVITY_ENTRY] 的属性 地区
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置[WX_ACTIVITY_ENTRY]的属性地区
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * 获取 [WX_ACTIVITY_ENTRY] 的属性 电话
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置[WX_ACTIVITY_ENTRY]的属性电话
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取 [WX_ACTIVITY_ENTRY] 的属性 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置[WX_ACTIVITY_ENTRY]的属性年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取 [WX_ACTIVITY_ENTRY] 的属性 车型
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置[WX_ACTIVITY_ENTRY]的属性车型
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * 获取 [WX_ACTIVITY_ENTRY] 的属性 性别 1.男 2.女
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     * 设置[WX_ACTIVITY_ENTRY]的属性性别 1.男 2.女
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * 获取 [WX_ACTIVITY_ENTRY] 的属性 报名状态: 0:已申请 1.已通过 2.未通过
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置[WX_ACTIVITY_ENTRY]的属性报名状态: 0:已申请 1.已通过 2.未通过
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取 [WX_ACTIVITY_ENTRY] 的属性 创建者
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置[WX_ACTIVITY_ENTRY]的属性创建者
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取 [WX_ACTIVITY_ENTRY] 的属性 创建者姓名
     */
    public String getCreatedName() {
        return createdName;
    }

    /**
     * 设置[WX_ACTIVITY_ENTRY]的属性创建者姓名
     */
    public void setCreatedName(String createdName) {
        this.createdName = createdName == null ? null : createdName.trim();
    }

    /**
     * 获取 [WX_ACTIVITY_ENTRY] 的属性 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置[WX_ACTIVITY_ENTRY]的属性创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取 [WX_ACTIVITY_ENTRY] 的属性 更新者
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置[WX_ACTIVITY_ENTRY]的属性更新者
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取 [WX_ACTIVITY_ENTRY] 的属性 更新者姓名
     */
    public String getUpdatedName() {
        return updatedName;
    }

    /**
     * 设置[WX_ACTIVITY_ENTRY]的属性更新者姓名
     */
    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName == null ? null : updatedName.trim();
    }

    /**
     * 获取 [WX_ACTIVITY_ENTRY] 的属性 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置[WX_ACTIVITY_ENTRY]的属性更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取 [WX_ACTIVITY_ENTRY] 的属性 数据版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置[WX_ACTIVITY_ENTRY]的属性数据版本
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}