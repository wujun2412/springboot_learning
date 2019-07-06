package com.wujun.dao;

import com.wujun.domain.WxTag;

public interface WxTagMapper {
    int deleteByPrimaryKey(Long tagId);

    int insert(WxTag record);

    int insertSelective(WxTag record);

    WxTag selectByPrimaryKey(Long tagId);

    int updateByPrimaryKeySelective(WxTag record);

    int updateByPrimaryKey(WxTag record);
}