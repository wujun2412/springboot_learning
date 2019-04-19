package com.wujun.domain;

import java.util.Date;

public class WxArticleForbidUser {
    /**
     * 主键
     */
    private Long forbidId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 禁言时长
     */
    private Integer forbidLength;

    /**
     * 禁言时间
     */
    private Date forbidTime;

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
     * 获取 [WX_ARTICLE_FORBID_USER] 的属性 主键
     */
    public Long getForbidId() {
        return forbidId;
    }

    /**
     * 设置[WX_ARTICLE_FORBID_USER]的属性主键
     */
    public void setForbidId(Long forbidId) {
        this.forbidId = forbidId;
    }

    /**
     * 获取 [WX_ARTICLE_FORBID_USER] 的属性 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置[WX_ARTICLE_FORBID_USER]的属性用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 [WX_ARTICLE_FORBID_USER] 的属性 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置[WX_ARTICLE_FORBID_USER]的属性用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取 [WX_ARTICLE_FORBID_USER] 的属性 禁言时长
     */
    public Integer getForbidLength() {
        return forbidLength;
    }

    /**
     * 设置[WX_ARTICLE_FORBID_USER]的属性禁言时长
     */
    public void setForbidLength(Integer forbidLength) {
        this.forbidLength = forbidLength;
    }

    /**
     * 获取 [WX_ARTICLE_FORBID_USER] 的属性 禁言时间
     */
    public Date getForbidTime() {
        return forbidTime;
    }

    /**
     * 设置[WX_ARTICLE_FORBID_USER]的属性禁言时间
     */
    public void setForbidTime(Date forbidTime) {
        this.forbidTime = forbidTime;
    }

    /**
     * 获取 [WX_ARTICLE_FORBID_USER] 的属性 创建者
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置[WX_ARTICLE_FORBID_USER]的属性创建者
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取 [WX_ARTICLE_FORBID_USER] 的属性 创建者姓名
     */
    public String getCreatedName() {
        return createdName;
    }

    /**
     * 设置[WX_ARTICLE_FORBID_USER]的属性创建者姓名
     */
    public void setCreatedName(String createdName) {
        this.createdName = createdName == null ? null : createdName.trim();
    }

    /**
     * 获取 [WX_ARTICLE_FORBID_USER] 的属性 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置[WX_ARTICLE_FORBID_USER]的属性创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取 [WX_ARTICLE_FORBID_USER] 的属性 更新者
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置[WX_ARTICLE_FORBID_USER]的属性更新者
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取 [WX_ARTICLE_FORBID_USER] 的属性 更新者姓名
     */
    public String getUpdatedName() {
        return updatedName;
    }

    /**
     * 设置[WX_ARTICLE_FORBID_USER]的属性更新者姓名
     */
    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName == null ? null : updatedName.trim();
    }

    /**
     * 获取 [WX_ARTICLE_FORBID_USER] 的属性 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置[WX_ARTICLE_FORBID_USER]的属性更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取 [WX_ARTICLE_FORBID_USER] 的属性 数据版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置[WX_ARTICLE_FORBID_USER]的属性数据版本
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}