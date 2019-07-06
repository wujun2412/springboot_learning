package com.wujun.dao;

import com.wujun.domain.WxArticleChannel;

public interface WxArticleChannelMapper {
    int deleteByPrimaryKey(Long channelId);

    int insert(WxArticleChannel record);

    int insertSelective(WxArticleChannel record);

    WxArticleChannel selectByPrimaryKey(Long channelId);

    int updateByPrimaryKeySelective(WxArticleChannel record);

    int updateByPrimaryKey(WxArticleChannel record);
}