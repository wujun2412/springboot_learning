package com.wujun.dao;

import com.wujun.domain.WxActivity;

public interface WxActivityMapper {
    int deleteByPrimaryKey(Long activityId);

    int insert(WxActivity record);

    int insertSelective(WxActivity record);

    WxActivity selectByPrimaryKey(Long activityId);

    int updateByPrimaryKeySelective(WxActivity record);

    int updateByPrimaryKeyWithBLOBs(WxActivity record);

    int updateByPrimaryKey(WxActivity record);
}