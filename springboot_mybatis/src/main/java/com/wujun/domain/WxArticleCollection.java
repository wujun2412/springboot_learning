package com.wujun.domain;

import java.util.Date;

public class WxArticleCollection {
    /**
     * 主键
     */
    private Long articleCollectionId;

    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 获取 [WX_ARTICLE_COLLECTION] 的属性 主键
     */
    public Long getArticleCollectionId() {
        return articleCollectionId;
    }

    /**
     * 设置[WX_ARTICLE_COLLECTION]的属性主键
     */
    public void setArticleCollectionId(Long articleCollectionId) {
        this.articleCollectionId = articleCollectionId;
    }

    /**
     * 获取 [WX_ARTICLE_COLLECTION] 的属性 文章ID
     */
    public Long getArticleId() {
        return articleId;
    }

    /**
     * 设置[WX_ARTICLE_COLLECTION]的属性文章ID
     */
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取 [WX_ARTICLE_COLLECTION] 的属性 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置[WX_ARTICLE_COLLECTION]的属性用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 [WX_ARTICLE_COLLECTION] 的属性 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置[WX_ARTICLE_COLLECTION]的属性创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}