package com.wujun.domain;

import java.util.Date;

public class WxIntroduceActivityOrder {
    /**
     * 主键
     */
    private Long orderId;

    /**
     * 订单编号
     */
    private String orderCode;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 客户姓名
     */
    private String name;

    /**
     * 客户电话
     */
    private String mobile;

    /**
     * 奖品设置(多个奖品以分号(;)分隔)
     */
    private String awardSetting;

    /**
     * 订单时间
     */
    private Date orderTime;

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
     * 订单状态 0:待发货 1:已发货 2.已取消
     */
    private Boolean status;

    /**
     * 快递名称
     */
    private String expressName;

    /**
     * 快递单号
     */
    private String expressNumber;

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
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 主键
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性主键
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 订单编号
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性订单编号
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 活动ID
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性活动ID
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 客户姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性客户姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 客户电话
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性客户电话
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 奖品设置(多个奖品以分号(;)分隔)
     */
    public String getAwardSetting() {
        return awardSetting;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性奖品设置(多个奖品以分号(;)分隔)
     */
    public void setAwardSetting(String awardSetting) {
        this.awardSetting = awardSetting == null ? null : awardSetting.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 订单时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性订单时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 省份
     */
    public Long getProvince() {
        return province;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性省份
     */
    public void setProvince(Long province) {
        this.province = province;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 城市
     */
    public Long getCity() {
        return city;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性城市
     */
    public void setCity(Long city) {
        this.city = city;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 区县
     */
    public Long getCounty() {
        return county;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性区县
     */
    public void setCounty(Long county) {
        this.county = county;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 订单状态 0:待发货 1:已发货 2.已取消
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性订单状态 0:待发货 1:已发货 2.已取消
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 快递名称
     */
    public String getExpressName() {
        return expressName;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性快递名称
     */
    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 快递单号
     */
    public String getExpressNumber() {
        return expressNumber;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性快递单号
     */
    public void setExpressNumber(String expressNumber) {
        this.expressNumber = expressNumber == null ? null : expressNumber.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 创建者
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性创建者
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 创建者姓名
     */
    public String getCreatedName() {
        return createdName;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性创建者姓名
     */
    public void setCreatedName(String createdName) {
        this.createdName = createdName == null ? null : createdName.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 更新者
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性更新者
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 更新者姓名
     */
    public String getUpdatedName() {
        return updatedName;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性更新者姓名
     */
    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName == null ? null : updatedName.trim();
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取 [WX_INTRODUCE_ACTIVITY_ORDER] 的属性 数据版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置[WX_INTRODUCE_ACTIVITY_ORDER]的属性数据版本
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}