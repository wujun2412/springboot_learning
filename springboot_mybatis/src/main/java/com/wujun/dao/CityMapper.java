package com.wujun.dao;

import com.wujun.domain.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);

    List<City> selectByName(@Param("name") String name);

    List<City> selectCities(@Param("city") City city);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}