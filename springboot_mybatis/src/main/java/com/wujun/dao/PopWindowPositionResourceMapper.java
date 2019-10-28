package com.wujun.dao;

import com.wujun.domain.PopWindowPositionResource;

public interface PopWindowPositionResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PopWindowPositionResource record);

    int insertSelective(PopWindowPositionResource record);

    PopWindowPositionResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PopWindowPositionResource record);

    int updateByPrimaryKey(PopWindowPositionResource record);
}