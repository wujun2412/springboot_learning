package com.wujun.dao;

import com.wujun.domain.WxIntroduceActivityOrder;

public interface WxIntroduceActivityOrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(WxIntroduceActivityOrder record);

    int insertSelective(WxIntroduceActivityOrder record);

    WxIntroduceActivityOrder selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(WxIntroduceActivityOrder record);

    int updateByPrimaryKey(WxIntroduceActivityOrder record);
}