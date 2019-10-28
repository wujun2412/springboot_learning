package com.wujun.dao;

import com.wujun.domain.PopWindowPage;

public interface PopWindowPageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PopWindowPage record);

    int insertSelective(PopWindowPage record);

    PopWindowPage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PopWindowPage record);

    int updateByPrimaryKey(PopWindowPage record);
}