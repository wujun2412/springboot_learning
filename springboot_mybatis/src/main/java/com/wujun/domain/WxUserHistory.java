package com.wujun.domain;

import java.util.Date;

public class WxUserHistory {
    /**
     * 主键
     */
    private Long historyId;

    /**
     * 文章/活动/问卷/投票 ID
     */
    private Long businessId;

    /**
     * 业务类型：评论/收藏/点赞/浏览/问卷/投票
     */
    private Integer businessType;

    /**
     * 个人中心tag页：参与/收藏/足迹/赞
     */
    private Integer tagType;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新者
     */
    private Long updatedBy;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 数据版本
     */
    private Integer version;

    /**
     * 获取 [WX_USER_HISTORY] 的属性 主键
     */
    public Long getHistoryId() {
        return historyId;
    }

    /**
     * 设置[WX_USER_HISTORY]的属性主键
     */
    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    /**
     * 获取 [WX_USER_HISTORY] 的属性 文章/活动/问卷/投票 ID
     */
    public Long getBusinessId() {
        return businessId;
    }

    /**
     * 设置[WX_USER_HISTORY]的属性文章/活动/问卷/投票 ID
     */
    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    /**
     * 获取 [WX_USER_HISTORY] 的属性 业务类型：评论/收藏/点赞/浏览/问卷/投票
     */
    public Integer getBusinessType() {
        return businessType;
    }

    /**
     * 设置[WX_USER_HISTORY]的属性业务类型：评论/收藏/点赞/浏览/问卷/投票
     */
    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    /**
     * 获取 [WX_USER_HISTORY] 的属性 个人中心tag页：参与/收藏/足迹/赞
     */
    public Integer getTagType() {
        return tagType;
    }

    /**
     * 设置[WX_USER_HISTORY]的属性个人中心tag页：参与/收藏/足迹/赞
     */
    public void setTagType(Integer tagType) {
        this.tagType = tagType;
    }

    /**
     * 获取 [WX_USER_HISTORY] 的属性 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置[WX_USER_HISTORY]的属性用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 [WX_USER_HISTORY] 的属性 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置[WX_USER_HISTORY]的属性用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取 [WX_USER_HISTORY] 的属性 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置[WX_USER_HISTORY]的属性创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取 [WX_USER_HISTORY] 的属性 更新者
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置[WX_USER_HISTORY]的属性更新者
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取 [WX_USER_HISTORY] 的属性 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置[WX_USER_HISTORY]的属性更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取 [WX_USER_HISTORY] 的属性 数据版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置[WX_USER_HISTORY]的属性数据版本
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}