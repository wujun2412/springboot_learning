package com.wujun.dao;

import com.wujun.domain.WxArticleImage;

public interface WxArticleImageMapper {
    int deleteByPrimaryKey(Long articleImageId);

    int insert(WxArticleImage record);

    int insertSelective(WxArticleImage record);

    WxArticleImage selectByPrimaryKey(Long articleImageId);

    int updateByPrimaryKeySelective(WxArticleImage record);

    int updateByPrimaryKey(WxArticleImage record);
}