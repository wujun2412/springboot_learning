package com.wujun.domain;

import java.util.Date;

public class WxIntroduceActivity {
    /**
     * 主键
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 封面图片(最多3张，最少1张，多图片ID以逗号分隔)
     */
    private String coverImage;

    /**
     * 是否置顶0：否 1：是
     */
    private Boolean isTop;

    /**
     * 封面是否大图0:否 1:是
     */
    private Boolean isBigImg;

    /**
     * 允许报名人数
     */
    private Integer allowEntryCount;

    /**
     * 目标客户(0:全部客户 1:有车客户 2:无车客户)
     */
    private Boolean targetCustomer;

    /**
     * 活动车系代码(单个各系)
     */
    private String activitySeries;

    /**
     * 活动开始时间
     */
    private Date startTime;

    /**
     * 活动结束时间
     */
    private Date endTime;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 0:待发布 1:已发布 2.已下架
     */
    private Boolean status;

    /**
     * 奖品设置(多个奖品以分好(;)分隔)
     */
    private String awardSetting;

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
     * 活动描述
     */
    private String description;

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 主键
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性主键
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 活动名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性活动名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 封面图片(最多3张，最少1张，多图片ID以逗号分隔)
     */
    public String getCoverImage() {
        return coverImage;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性封面图片(最多3张，最少1张，多图片ID以逗号分隔)
     */
    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage == null ? null : coverImage.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 是否置顶0：否 1：是
     */
    public Boolean getIsTop() {
        return isTop;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性是否置顶0：否 1：是
     */
    public void setIsTop(Boolean isTop) {
        this.isTop = isTop;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 封面是否大图0:否 1:是
     */
    public Boolean getIsBigImg() {
        return isBigImg;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性封面是否大图0:否 1:是
     */
    public void setIsBigImg(Boolean isBigImg) {
        this.isBigImg = isBigImg;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 允许报名人数
     */
    public Integer getAllowEntryCount() {
        return allowEntryCount;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性允许报名人数
     */
    public void setAllowEntryCount(Integer allowEntryCount) {
        this.allowEntryCount = allowEntryCount;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 目标客户(0:全部客户 1:有车客户 2:无车客户)
     */
    public Boolean getTargetCustomer() {
        return targetCustomer;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性目标客户(0:全部客户 1:有车客户 2:无车客户)
     */
    public void setTargetCustomer(Boolean targetCustomer) {
        this.targetCustomer = targetCustomer;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 活动车系代码(单个各系)
     */
    public String getActivitySeries() {
        return activitySeries;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性活动车系代码(单个各系)
     */
    public void setActivitySeries(String activitySeries) {
        this.activitySeries = activitySeries == null ? null : activitySeries.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 活动开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性活动开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 活动结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性活动结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 发布时间
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性发布时间
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 0:待发布 1:已发布 2.已下架
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性0:待发布 1:已发布 2.已下架
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 奖品设置(多个奖品以分好(;)分隔)
     */
    public String getAwardSetting() {
        return awardSetting;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性奖品设置(多个奖品以分好(;)分隔)
     */
    public void setAwardSetting(String awardSetting) {
        this.awardSetting = awardSetting == null ? null : awardSetting.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 创建者
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性创建者
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 创建者姓名
     */
    public String getCreatedName() {
        return createdName;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性创建者姓名
     */
    public void setCreatedName(String createdName) {
        this.createdName = createdName == null ? null : createdName.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 更新者
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性更新者
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 更新者姓名
     */
    public String getUpdatedName() {
        return updatedName;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性更新者姓名
     */
    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName == null ? null : updatedName.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 数据版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性数据版本
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY] 的属性 活动描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY]的属性活动描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}