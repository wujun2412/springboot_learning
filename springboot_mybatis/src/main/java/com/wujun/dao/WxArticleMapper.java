package com.wujun.dao;

import com.wujun.domain.WxArticle;

public interface WxArticleMapper {
    int deleteByPrimaryKey(Long articleId);

    int insert(WxArticle record);

    int insertSelective(WxArticle record);

    WxArticle selectByPrimaryKey(Long articleId);

    int updateByPrimaryKeySelective(WxArticle record);

    int updateByPrimaryKeyWithBLOBs(WxArticle record);

    int updateByPrimaryKey(WxArticle record);
}