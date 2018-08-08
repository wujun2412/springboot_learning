package com.wujun.dao;

import com.wujun.domain.NtCiReturningLogistics;

public interface NtCiReturningLogisticsMapper {
    int deleteByPrimaryKey(Long LOGISTICS_ID);

    int insert(NtCiReturningLogistics record);

    int insertSelective(NtCiReturningLogistics record);

    NtCiReturningLogistics selectByPrimaryKey(Long LOGISTICS_ID);

    int updateByPrimaryKeySelective(NtCiReturningLogistics record);

    int updateByPrimaryKey(NtCiReturningLogistics record);
}