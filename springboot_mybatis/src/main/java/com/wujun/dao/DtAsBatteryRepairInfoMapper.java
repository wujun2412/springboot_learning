package com.wujun.dao;

import com.wujun.domain.DtAsBatteryRepairInfo;

public interface DtAsBatteryRepairInfoMapper {
    int deleteByPrimaryKey(Long REPAIR_ID);

    int insert(DtAsBatteryRepairInfo record);

    int insertSelective(DtAsBatteryRepairInfo record);

    DtAsBatteryRepairInfo selectByPrimaryKey(Long REPAIR_ID);

    int updateByPrimaryKeySelective(DtAsBatteryRepairInfo record);

    int updateByPrimaryKey(DtAsBatteryRepairInfo record);
}