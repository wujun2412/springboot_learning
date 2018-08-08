package com.wujun.dao;

import com.wujun.domain.DtAsBatteryRetireInfo;

public interface DtAsBatteryRetireInfoMapper {
    int deleteByPrimaryKey(Long RETIRE_ID);

    int insert(DtAsBatteryRetireInfo record);

    int insertSelective(DtAsBatteryRetireInfo record);

    DtAsBatteryRetireInfo selectByPrimaryKey(Long RETIRE_ID);

    int updateByPrimaryKeySelective(DtAsBatteryRetireInfo record);

    int updateByPrimaryKey(DtAsBatteryRetireInfo record);
}