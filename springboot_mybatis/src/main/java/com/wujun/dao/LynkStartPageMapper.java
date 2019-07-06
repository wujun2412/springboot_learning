package com.wujun.dao;

import com.wujun.domain.LynkStartPage;

public interface LynkStartPageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LynkStartPage record);

    int insertSelective(LynkStartPage record);

    LynkStartPage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LynkStartPage record);

    int updateByPrimaryKey(LynkStartPage record);
}