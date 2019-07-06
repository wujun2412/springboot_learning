package com.wujun.domain;

public class WxArticleTag {
    /**
     * 主键
     */
    private Long articleTagId;

    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 标签ID
     */
    private Long tagId;

    /**
     * 获取 [WX_ARTICLE_TAG] 的属性 主键
     */
    public Long getArticleTagId() {
        return articleTagId;
    }

    /**
     * 设置[WX_ARTICLE_TAG]的属性主键
     */
    public void setArticleTagId(Long articleTagId) {
        this.articleTagId = articleTagId;
    }

    /**
     * 获取 [WX_ARTICLE_TAG] 的属性 文章ID
     */
    public Long getArticleId() {
        return articleId;
    }

    /**
     * 设置[WX_ARTICLE_TAG]的属性文章ID
     */
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取 [WX_ARTICLE_TAG] 的属性 标签ID
     */
    public Long getTagId() {
        return tagId;
    }

    /**
     * 设置[WX_ARTICLE_TAG]的属性标签ID
     */
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}