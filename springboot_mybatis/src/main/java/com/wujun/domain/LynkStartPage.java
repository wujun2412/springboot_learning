package com.wujun.domain;

import java.util.Date;

public class LynkStartPage {
    /**
     * 主键
     */
    private Long id;

    /**
     * 启动页名称
     */
    private String pageName;

    /**
     * 品牌:领克、吉利、几何...
     */
    private String brand;

    /**
     * 领克APP...
     */
    private String channel;

    /**
     * 启动页形式(0:静态图 1:动态图 2:微视频)
     */
    private Integer pageType;

    /**
     * 是否支持跳转(0:否 1:是)
     */
    private Integer canJump;

    /**
     * 跳转URL
     */
    private String jumpUrl;

    /**
     * 是否默认缺省(0:否 1:是)
     */
    private Integer isdefault;

    /**
     * 0:启用 1:停用
     */
    private Integer status;

    /**
     * 是否时间段显示(0:否 1:是)
     */
    private Integer enableTime;

    /**
     * 展示开始时间
     */
    private Date startTime;

    /**
     * 展示结束时间
     */
    private Date endTime;

    /**
     * 启动图片(IOS)
     */
    private String iosImage;

    /**
     * 启动图片(ANDROID)
     */
    private String androidImage;

    /**
     * 页面关闭倒计时
     */
    private Integer countdown;

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
     * 获取 [LYNK_START_PAGE] 的属性 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 启动页名称
     */
    public String getPageName() {
        return pageName;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性启动页名称
     */
    public void setPageName(String pageName) {
        this.pageName = pageName == null ? null : pageName.trim();
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 品牌:领克、吉利、几何...
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性品牌:领克、吉利、几何...
     */
    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 领克APP...
     */
    public String getChannel() {
        return channel;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性领克APP...
     */
    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 启动页形式(0:静态图 1:动态图 2:微视频)
     */
    public Integer getPageType() {
        return pageType;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性启动页形式(0:静态图 1:动态图 2:微视频)
     */
    public void setPageType(Integer pageType) {
        this.pageType = pageType;
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 是否支持跳转(0:否 1:是)
     */
    public Integer getCanJump() {
        return canJump;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性是否支持跳转(0:否 1:是)
     */
    public void setCanJump(Integer canJump) {
        this.canJump = canJump;
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 跳转URL
     */
    public String getJumpUrl() {
        return jumpUrl;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性跳转URL
     */
    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl == null ? null : jumpUrl.trim();
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 是否默认缺省(0:否 1:是)
     */
    public Integer getIsdefault() {
        return isdefault;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性是否默认缺省(0:否 1:是)
     */
    public void setIsdefault(Integer isdefault) {
        this.isdefault = isdefault;
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 0:启用 1:停用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性0:启用 1:停用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 是否时间段显示(0:否 1:是)
     */
    public Integer getEnableTime() {
        return enableTime;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性是否时间段显示(0:否 1:是)
     */
    public void setEnableTime(Integer enableTime) {
        this.enableTime = enableTime;
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 展示开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性展示开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 展示结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性展示结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 启动图片(IOS)
     */
    public String getIosImage() {
        return iosImage;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性启动图片(IOS)
     */
    public void setIosImage(String iosImage) {
        this.iosImage = iosImage == null ? null : iosImage.trim();
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 启动图片(ANDROID)
     */
    public String getAndroidImage() {
        return androidImage;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性启动图片(ANDROID)
     */
    public void setAndroidImage(String androidImage) {
        this.androidImage = androidImage == null ? null : androidImage.trim();
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 页面关闭倒计时
     */
    public Integer getCountdown() {
        return countdown;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性页面关闭倒计时
     */
    public void setCountdown(Integer countdown) {
        this.countdown = countdown;
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 创建者
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性创建者
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 创建者姓名
     */
    public String getCreatedName() {
        return createdName;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性创建者姓名
     */
    public void setCreatedName(String createdName) {
        this.createdName = createdName == null ? null : createdName.trim();
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 更新者
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性更新者
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 更新者姓名
     */
    public String getUpdatedName() {
        return updatedName;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性更新者姓名
     */
    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName == null ? null : updatedName.trim();
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取 [LYNK_START_PAGE] 的属性 数据版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置[LYNK_START_PAGE]的属性数据版本
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}