package com.wujun.dao;

import com.wujun.domain.WxUserHistory;

public interface WxUserHistoryMapper {
    int deleteByPrimaryKey(Long historyId);

    int insert(WxUserHistory record);

    int insertSelective(WxUserHistory record);

    WxUserHistory selectByPrimaryKey(Long historyId);

    int updateByPrimaryKeySelective(WxUserHistory record);

    int updateByPrimaryKey(WxUserHistory record);
}