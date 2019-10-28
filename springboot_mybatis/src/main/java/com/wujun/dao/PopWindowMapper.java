package com.wujun.dao;

import com.wujun.domain.PopWindow;

public interface PopWindowMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PopWindow record);

    int insertSelective(PopWindow record);

    PopWindow selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PopWindow record);

    int updateByPrimaryKey(PopWindow record);
}