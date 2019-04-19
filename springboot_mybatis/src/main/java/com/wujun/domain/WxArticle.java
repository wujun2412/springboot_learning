package com.wujun.domain;

import java.util.Date;

public class WxArticle {
    /**
     * 主键
     */
    private Long articleId;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 封面图片(最多3张，最少1张，多图片ID以逗号分隔)
     */
    private String coverImage;

    /**
     * 发布频道
     */
    private Long channelId;

    /**
     * 是否频道置顶0：否 1：是
     */
    private Boolean isChannelTop;

    /**
     * 是否开启评论0：否 1：是
     */
    private Boolean allowComment;

    /**
     * 是否允许匿名评论(0:否;1:是)
     */
    private Boolean allowAnon;

    /**
     * 目标客户(0:全部客户 1:有车客户 2:无车客户)
     */
    private Boolean targetCustomer;

    /**
     * 目标车系代码(多个车系用逗号分隔)
     */
    private String targetSeries;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 文章描述
     */
    private String remark;

    /**
     * 状态0:未发布，1:已发布
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
     * 文章内容
     */
    private String content;

    /**
     * 获取 [WX_ARTICLE] 的属性 主键
     */
    public Long getArticleId() {
        return articleId;
    }

    /**
     * 设置[WX_ARTICLE]的属性主键
     */
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 文章标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置[WX_ARTICLE]的属性文章标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置[WX_ARTICLE]的属性作者
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 封面图片(最多3张，最少1张，多图片ID以逗号分隔)
     */
    public String getCoverImage() {
        return coverImage;
    }

    /**
     * 设置[WX_ARTICLE]的属性封面图片(最多3张，最少1张，多图片ID以逗号分隔)
     */
    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage == null ? null : coverImage.trim();
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 发布频道
     */
    public Long getChannelId() {
        return channelId;
    }

    /**
     * 设置[WX_ARTICLE]的属性发布频道
     */
    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 是否频道置顶0：否 1：是
     */
    public Boolean getIsChannelTop() {
        return isChannelTop;
    }

    /**
     * 设置[WX_ARTICLE]的属性是否频道置顶0：否 1：是
     */
    public void setIsChannelTop(Boolean isChannelTop) {
        this.isChannelTop = isChannelTop;
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 是否开启评论0：否 1：是
     */
    public Boolean getAllowComment() {
        return allowComment;
    }

    /**
     * 设置[WX_ARTICLE]的属性是否开启评论0：否 1：是
     */
    public void setAllowComment(Boolean allowComment) {
        this.allowComment = allowComment;
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 是否允许匿名评论(0:否;1:是)
     */
    public Boolean getAllowAnon() {
        return allowAnon;
    }

    /**
     * 设置[WX_ARTICLE]的属性是否允许匿名评论(0:否;1:是)
     */
    public void setAllowAnon(Boolean allowAnon) {
        this.allowAnon = allowAnon;
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 目标客户(0:全部客户 1:有车客户 2:无车客户)
     */
    public Boolean getTargetCustomer() {
        return targetCustomer;
    }

    /**
     * 设置[WX_ARTICLE]的属性目标客户(0:全部客户 1:有车客户 2:无车客户)
     */
    public void setTargetCustomer(Boolean targetCustomer) {
        this.targetCustomer = targetCustomer;
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 目标车系代码(多个车系用逗号分隔)
     */
    public String getTargetSeries() {
        return targetSeries;
    }

    /**
     * 设置[WX_ARTICLE]的属性目标车系代码(多个车系用逗号分隔)
     */
    public void setTargetSeries(String targetSeries) {
        this.targetSeries = targetSeries == null ? null : targetSeries.trim();
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 发布时间
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * 设置[WX_ARTICLE]的属性发布时间
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 文章描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置[WX_ARTICLE]的属性文章描述
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 状态0:未发布，1:已发布
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置[WX_ARTICLE]的属性状态0:未发布，1:已发布
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 创建者
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置[WX_ARTICLE]的属性创建者
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 创建者姓名
     */
    public String getCreatedName() {
        return createdName;
    }

    /**
     * 设置[WX_ARTICLE]的属性创建者姓名
     */
    public void setCreatedName(String createdName) {
        this.createdName = createdName == null ? null : createdName.trim();
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置[WX_ARTICLE]的属性创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 更新者
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置[WX_ARTICLE]的属性更新者
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 更新者姓名
     */
    public String getUpdatedName() {
        return updatedName;
    }

    /**
     * 设置[WX_ARTICLE]的属性更新者姓名
     */
    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName == null ? null : updatedName.trim();
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置[WX_ARTICLE]的属性更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 数据版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置[WX_ARTICLE]的属性数据版本
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取 [WX_ARTICLE] 的属性 文章内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置[WX_ARTICLE]的属性文章内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}