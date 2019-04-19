package com.wujun.domain;

import java.util.Date;

public class WxActivity {
    /**
     * 主键
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动发起方
     */
    private String sponsor;

    /**
     * 封面图片(最多3张，最少1张，多图片ID以逗号分隔)
     */
    private String coverImage;

    /**
     * 排序值
     */
    private Integer sequenceNum;

    /**
     * 允许报名人数
     */
    private Integer allowEntryCount;

    /**
     * 是否需要审核,0:不需要 1:需要
     */
    private Boolean isneedaudit;

    /**
     * 目标客户(0:全部客户 1:有车客户 2:无车客户)
     */
    private Boolean targetCustomer;

    /**
     * 所需吉币
     */
    private Integer geelyCurrency;

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
     * 来源：1 微信 2 club
     */
    private Byte source;

    /**
     * 0:待发布 1:已发布 2.已下架
     */
    private Boolean status;

    /**
     * 卡券地址
     */
    private String couponAddress;

    /**
     * 卡券链接图片
     */
    private Long couponImg;

    /**
     * 留资设置(姓名:NAME,地区: REGION,电话:MOBILE,年龄:AGE,车型:MODEL,性别:SEX)
     */
    private String informationSetting;

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
     * 获取 [WX_ACTIVITY] 的属性 主键
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * 设置[WX_ACTIVITY]的属性主键
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 活动名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置[WX_ACTIVITY]的属性活动名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 活动发起方
     */
    public String getSponsor() {
        return sponsor;
    }

    /**
     * 设置[WX_ACTIVITY]的属性活动发起方
     */
    public void setSponsor(String sponsor) {
        this.sponsor = sponsor == null ? null : sponsor.trim();
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 封面图片(最多3张，最少1张，多图片ID以逗号分隔)
     */
    public String getCoverImage() {
        return coverImage;
    }

    /**
     * 设置[WX_ACTIVITY]的属性封面图片(最多3张，最少1张，多图片ID以逗号分隔)
     */
    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage == null ? null : coverImage.trim();
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 排序值
     */
    public Integer getSequenceNum() {
        return sequenceNum;
    }

    /**
     * 设置[WX_ACTIVITY]的属性排序值
     */
    public void setSequenceNum(Integer sequenceNum) {
        this.sequenceNum = sequenceNum;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 允许报名人数
     */
    public Integer getAllowEntryCount() {
        return allowEntryCount;
    }

    /**
     * 设置[WX_ACTIVITY]的属性允许报名人数
     */
    public void setAllowEntryCount(Integer allowEntryCount) {
        this.allowEntryCount = allowEntryCount;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 是否需要审核,0:不需要 1:需要
     */
    public Boolean getIsneedaudit() {
        return isneedaudit;
    }

    /**
     * 设置[WX_ACTIVITY]的属性是否需要审核,0:不需要 1:需要
     */
    public void setIsneedaudit(Boolean isneedaudit) {
        this.isneedaudit = isneedaudit;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 目标客户(0:全部客户 1:有车客户 2:无车客户)
     */
    public Boolean getTargetCustomer() {
        return targetCustomer;
    }

    /**
     * 设置[WX_ACTIVITY]的属性目标客户(0:全部客户 1:有车客户 2:无车客户)
     */
    public void setTargetCustomer(Boolean targetCustomer) {
        this.targetCustomer = targetCustomer;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 所需吉币
     */
    public Integer getGeelyCurrency() {
        return geelyCurrency;
    }

    /**
     * 设置[WX_ACTIVITY]的属性所需吉币
     */
    public void setGeelyCurrency(Integer geelyCurrency) {
        this.geelyCurrency = geelyCurrency;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 国家
     */
    public Long getCountry() {
        return country;
    }

    /**
     * 设置[WX_ACTIVITY]的属性国家
     */
    public void setCountry(Long country) {
        this.country = country;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 省份
     */
    public Long getProvince() {
        return province;
    }

    /**
     * 设置[WX_ACTIVITY]的属性省份
     */
    public void setProvince(Long province) {
        this.province = province;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 城市
     */
    public Long getCity() {
        return city;
    }

    /**
     * 设置[WX_ACTIVITY]的属性城市
     */
    public void setCity(Long city) {
        this.city = city;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 区县
     */
    public Long getCounty() {
        return county;
    }

    /**
     * 设置[WX_ACTIVITY]的属性区县
     */
    public void setCounty(Long county) {
        this.county = county;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置[WX_ACTIVITY]的属性详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 活动开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置[WX_ACTIVITY]的属性活动开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 活动结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置[WX_ACTIVITY]的属性活动结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 发布时间
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * 设置[WX_ACTIVITY]的属性发布时间
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 来源：1 微信 2 club
     */
    public Byte getSource() {
        return source;
    }

    /**
     * 设置[WX_ACTIVITY]的属性来源：1 微信 2 club
     */
    public void setSource(Byte source) {
        this.source = source;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 0:待发布 1:已发布 2.已下架
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置[WX_ACTIVITY]的属性0:待发布 1:已发布 2.已下架
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 卡券地址
     */
    public String getCouponAddress() {
        return couponAddress;
    }

    /**
     * 设置[WX_ACTIVITY]的属性卡券地址
     */
    public void setCouponAddress(String couponAddress) {
        this.couponAddress = couponAddress == null ? null : couponAddress.trim();
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 卡券链接图片
     */
    public Long getCouponImg() {
        return couponImg;
    }

    /**
     * 设置[WX_ACTIVITY]的属性卡券链接图片
     */
    public void setCouponImg(Long couponImg) {
        this.couponImg = couponImg;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 留资设置(姓名:NAME,地区: REGION,电话:MOBILE,年龄:AGE,车型:MODEL,性别:SEX)
     */
    public String getInformationSetting() {
        return informationSetting;
    }

    /**
     * 设置[WX_ACTIVITY]的属性留资设置(姓名:NAME,地区: REGION,电话:MOBILE,年龄:AGE,车型:MODEL,性别:SEX)
     */
    public void setInformationSetting(String informationSetting) {
        this.informationSetting = informationSetting == null ? null : informationSetting.trim();
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 创建者
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置[WX_ACTIVITY]的属性创建者
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 创建者姓名
     */
    public String getCreatedName() {
        return createdName;
    }

    /**
     * 设置[WX_ACTIVITY]的属性创建者姓名
     */
    public void setCreatedName(String createdName) {
        this.createdName = createdName == null ? null : createdName.trim();
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置[WX_ACTIVITY]的属性创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 更新者
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置[WX_ACTIVITY]的属性更新者
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 更新者姓名
     */
    public String getUpdatedName() {
        return updatedName;
    }

    /**
     * 设置[WX_ACTIVITY]的属性更新者姓名
     */
    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName == null ? null : updatedName.trim();
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置[WX_ACTIVITY]的属性更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 数据版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置[WX_ACTIVITY]的属性数据版本
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取 [WX_ACTIVITY] 的属性 活动描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置[WX_ACTIVITY]的属性活动描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}