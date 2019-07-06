package com.wujun.domain;

import java.util.Date;

public class WxArticleChannel {
    /**
     * 主键
     */
    private Long channelId;

    /**
     * 频道名称
     */
    private String channelName;

    /**
     * 状态0:未启用，1已启用
     */
    private Boolean status;

    /**
     * 频道描述描述
     */
    private String remark;

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
     * 获取 [WX_ARTICLE_CHANNEL] 的属性 主键
     */
    public Long getChannelId() {
        return channelId;
    }

    /**
     * 设置[WX_ARTICLE_CHANNEL]的属性主键
     */
    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取 [WX_ARTICLE_CHANNEL] 的属性 频道名称
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * 设置[WX_ARTICLE_CHANNEL]的属性频道名称
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    /**
     * 获取 [WX_ARTICLE_CHANNEL] 的属性 状态0:未启用，1已启用
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置[WX_ARTICLE_CHANNEL]的属性状态0:未启用，1已启用
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取 [WX_ARTICLE_CHANNEL] 的属性 频道描述描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置[WX_ARTICLE_CHANNEL]的属性频道描述描述
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取 [WX_ARTICLE_CHANNEL] 的属性 创建者
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置[WX_ARTICLE_CHANNEL]的属性创建者
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取 [WX_ARTICLE_CHANNEL] 的属性 创建者姓名
     */
    public String getCreatedName() {
        return createdName;
    }

    /**
     * 设置[WX_ARTICLE_CHANNEL]的属性创建者姓名
     */
    public void setCreatedName(String createdName) {
        this.createdName = createdName == null ? null : createdName.trim();
    }

    /**
     * 获取 [WX_ARTICLE_CHANNEL] 的属性 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置[WX_ARTICLE_CHANNEL]的属性创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取 [WX_ARTICLE_CHANNEL] 的属性 更新者
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置[WX_ARTICLE_CHANNEL]的属性更新者
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取 [WX_ARTICLE_CHANNEL] 的属性 更新者姓名
     */
    public String getUpdatedName() {
        return updatedName;
    }

    /**
     * 设置[WX_ARTICLE_CHANNEL]的属性更新者姓名
     */
    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName == null ? null : updatedName.trim();
    }

    /**
     * 获取 [WX_ARTICLE_CHANNEL] 的属性 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置[WX_ARTICLE_CHANNEL]的属性更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取 [WX_ARTICLE_CHANNEL] 的属性 数据版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置[WX_ARTICLE_CHANNEL]的属性数据版本
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}