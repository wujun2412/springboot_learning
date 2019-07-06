package com.wujun.domain;

import java.util.Date;

public class WxArticleComment {
    /**
     * 主键
     */
    private Long commentId;

    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 评论内容
     */
    private Long content;

    /**
     * 状态0:上架中，1:下架中
     */
    private Boolean status;

    /**
     * 评论时间
     */
    private Date commentTime;

    /**
     * 评论用户ID
     */
    private Long commentBy;

    /**
     * 评论用户名
     */
    private String commentName;

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
     * 获取 [WX_ARTICLE_COMMENT] 的属性 主键
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * 设置[WX_ARTICLE_COMMENT]的属性主键
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取 [WX_ARTICLE_COMMENT] 的属性 文章ID
     */
    public Long getArticleId() {
        return articleId;
    }

    /**
     * 设置[WX_ARTICLE_COMMENT]的属性文章ID
     */
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取 [WX_ARTICLE_COMMENT] 的属性 评论内容
     */
    public Long getContent() {
        return content;
    }

    /**
     * 设置[WX_ARTICLE_COMMENT]的属性评论内容
     */
    public void setContent(Long content) {
        this.content = content;
    }

    /**
     * 获取 [WX_ARTICLE_COMMENT] 的属性 状态0:上架中，1:下架中
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置[WX_ARTICLE_COMMENT]的属性状态0:上架中，1:下架中
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取 [WX_ARTICLE_COMMENT] 的属性 评论时间
     */
    public Date getCommentTime() {
        return commentTime;
    }

    /**
     * 设置[WX_ARTICLE_COMMENT]的属性评论时间
     */
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    /**
     * 获取 [WX_ARTICLE_COMMENT] 的属性 评论用户ID
     */
    public Long getCommentBy() {
        return commentBy;
    }

    /**
     * 设置[WX_ARTICLE_COMMENT]的属性评论用户ID
     */
    public void setCommentBy(Long commentBy) {
        this.commentBy = commentBy;
    }

    /**
     * 获取 [WX_ARTICLE_COMMENT] 的属性 评论用户名
     */
    public String getCommentName() {
        return commentName;
    }

    /**
     * 设置[WX_ARTICLE_COMMENT]的属性评论用户名
     */
    public void setCommentName(String commentName) {
        this.commentName = commentName == null ? null : commentName.trim();
    }

    /**
     * 获取 [WX_ARTICLE_COMMENT] 的属性 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置[WX_ARTICLE_COMMENT]的属性创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取 [WX_ARTICLE_COMMENT] 的属性 更新者
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置[WX_ARTICLE_COMMENT]的属性更新者
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取 [WX_ARTICLE_COMMENT] 的属性 更新者姓名
     */
    public String getUpdatedName() {
        return updatedName;
    }

    /**
     * 设置[WX_ARTICLE_COMMENT]的属性更新者姓名
     */
    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName == null ? null : updatedName.trim();
    }

    /**
     * 获取 [WX_ARTICLE_COMMENT] 的属性 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置[WX_ARTICLE_COMMENT]的属性更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取 [WX_ARTICLE_COMMENT] 的属性 数据版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置[WX_ARTICLE_COMMENT]的属性数据版本
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}