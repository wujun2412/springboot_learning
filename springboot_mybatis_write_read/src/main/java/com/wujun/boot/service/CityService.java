package com.wujun.boot.service;

import com.wujun.boot.domain.City;

/**
 * @author wujun
 * @description
 * @date 18/1/19.
 */
public interface CityService {

    Integer saveCity(City city);

    City findById(Integer id);
}
