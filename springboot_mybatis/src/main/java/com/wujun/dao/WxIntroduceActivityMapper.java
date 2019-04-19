package com.wujun.dao;

import com.wujun.domain.WxIntroduceActivity;

public interface WxIntroduceActivityMapper {
    int deleteByPrimaryKey(Long activityId);

    int insert(WxIntroduceActivity record);

    int insertSelective(WxIntroduceActivity record);

    WxIntroduceActivity selectByPrimaryKey(Long activityId);

    int updateByPrimaryKeySelective(WxIntroduceActivity record);

    int updateByPrimaryKeyWithBLOBs(WxIntroduceActivity record);

    int updateByPrimaryKey(WxIntroduceActivity record);
}