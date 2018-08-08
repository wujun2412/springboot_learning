package com.wujun.dao;

import com.wujun.domain.DtBbBatteryRecycleUnit;

public interface DtBbBatteryRecycleUnitMapper {
    int deleteByPrimaryKey(Integer UNIT_ID);

    int insert(DtBbBatteryRecycleUnit record);

    int insertSelective(DtBbBatteryRecycleUnit record);

    DtBbBatteryRecycleUnit selectByPrimaryKey(Integer UNIT_ID);

    int updateByPrimaryKeySelective(DtBbBatteryRecycleUnit record);

    int updateByPrimaryKey(DtBbBatteryRecycleUnit record);
}