package com.wujun.dao;

import com.wujun.domain.WxIntroduceActivityEntry;

public interface WxIntroduceActivityEntryMapper {
    int deleteByPrimaryKey(Long entryId);

    int insert(WxIntroduceActivityEntry record);

    int insertSelective(WxIntroduceActivityEntry record);

    WxIntroduceActivityEntry selectByPrimaryKey(Long entryId);

    int updateByPrimaryKeySelective(WxIntroduceActivityEntry record);

    int updateByPrimaryKey(WxIntroduceActivityEntry record);
}