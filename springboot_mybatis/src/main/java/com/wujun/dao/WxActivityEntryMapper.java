package com.wujun.dao;

import com.wujun.domain.WxActivityEntry;

public interface WxActivityEntryMapper {
    int deleteByPrimaryKey(Long entryId);

    int insert(WxActivityEntry record);

    int insertSelective(WxActivityEntry record);

    WxActivityEntry selectByPrimaryKey(Long entryId);

    int updateByPrimaryKeySelective(WxActivityEntry record);

    int updateByPrimaryKey(WxActivityEntry record);
}