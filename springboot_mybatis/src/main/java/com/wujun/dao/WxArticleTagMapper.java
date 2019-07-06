package com.wujun.dao;

import com.wujun.domain.WxArticleTag;

public interface WxArticleTagMapper {
    int deleteByPrimaryKey(Long articleTagId);

    int insert(WxArticleTag record);

    int insertSelective(WxArticleTag record);

    WxArticleTag selectByPrimaryKey(Long articleTagId);

    int updateByPrimaryKeySelective(WxArticleTag record);

    int updateByPrimaryKey(WxArticleTag record);
}