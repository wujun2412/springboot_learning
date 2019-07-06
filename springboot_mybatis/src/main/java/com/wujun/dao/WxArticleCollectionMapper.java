package com.wujun.dao;

import com.wujun.domain.WxArticleCollection;

public interface WxArticleCollectionMapper {
    int deleteByPrimaryKey(Long articleCollectionId);

    int insert(WxArticleCollection record);

    int insertSelective(WxArticleCollection record);

    WxArticleCollection selectByPrimaryKey(Long articleCollectionId);

    int updateByPrimaryKeySelective(WxArticleCollection record);

    int updateByPrimaryKey(WxArticleCollection record);
}