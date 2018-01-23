package com.wujun.common.service.impl;

import com.wujun.dao.CityMapper;
import com.wujun.domain.City;
import com.wujun.common.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wujun
 * @description
 * @date 18/1/10.
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> getCityByName(String cityName) {
        return cityMapper.selectByName(cityName);
    }

    @Override
    public List<City> getCities(City city) {
        return cityMapper.selectCities(city);
    }

    @Override
    public Integer saveCity(City city){
        return cityMapper.insert(city);
    }
}
