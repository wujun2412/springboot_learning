package com.wujun.dao;

import com.wujun.domain.PopWindowPosition;

public interface PopWindowPositionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PopWindowPosition record);

    int insertSelective(PopWindowPosition record);

    PopWindowPosition selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PopWindowPosition record);

    int updateByPrimaryKey(PopWindowPosition record);
}