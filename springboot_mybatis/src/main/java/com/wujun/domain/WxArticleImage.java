package com.wujun.domain;

public class WxArticleImage {
    /**
     * 主键
     */
    private Long articleImageId;

    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 图片ID
     */
    private Long imageFileId;

    /**
     * 获取 [WX_ARTICLE_IMAGE] 的属性 主键
     */
    public Long getArticleImageId() {
        return articleImageId;
    }

    /**
     * 设置[WX_ARTICLE_IMAGE]的属性主键
     */
    public void setArticleImageId(Long articleImageId) {
        this.articleImageId = articleImageId;
    }

    /**
     * 获取 [WX_ARTICLE_IMAGE] 的属性 文章ID
     */
    public Long getArticleId() {
        return articleId;
    }

    /**
     * 设置[WX_ARTICLE_IMAGE]的属性文章ID
     */
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取 [WX_ARTICLE_IMAGE] 的属性 图片ID
     */
    public Long getImageFileId() {
        return imageFileId;
    }

    /**
     * 设置[WX_ARTICLE_IMAGE]的属性图片ID
     */
    public void setImageFileId(Long imageFileId) {
        this.imageFileId = imageFileId;
    }
}