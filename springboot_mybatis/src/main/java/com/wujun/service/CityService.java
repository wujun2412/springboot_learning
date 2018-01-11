package com.wujun.service;

import com.wujun.domain.City;

import java.util.List;

/**
 * @author wujun
 * @description
 * @date 18/1/10.
 */
public interface CityService {

    List<City> getCityByName(String cityName);

    List<City> getCities(City city);

    Integer saveCity(City city);
}
