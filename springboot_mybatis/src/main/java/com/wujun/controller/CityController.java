package com.wujun.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wujun.domain.City;
import com.wujun.requests.CityRequest;
import com.wujun.responses.Response;
import com.wujun.common.service.CityService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wujun
 * @description
 * @date 18/1/10.
 */
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private DozerBeanMapper dozerMapper;


    @RequestMapping(value = "/",method = RequestMethod.POST)
    public List<City> getCities(@RequestParam(value = "cityName",required = false)String cityName){

        return cityService.getCityByName(cityName);

    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Response saveCity(@RequestBody CityRequest cityRequest){
        City city = dozerMapper.map(cityRequest,City.class);
        cityService.saveCity(city);

        return Response.success();
    }


    @RequestMapping(value = "/page",method = RequestMethod.POST)
    public PageInfo<City> getCitiesByPage(@RequestBody CityRequest cityRequest){
        PageHelper.startPage(cityRequest.getCurrentPage(),cityRequest.getPageSize());
        //City city = fromRequestTo(cityRequest);
        City city = dozerMapper.map(cityRequest,City.class);
        List<City> cities = cityService.getCities(city);

        PageInfo pageInfo = new PageInfo(cities);
        Page page = (Page) cities;

        return pageInfo;
    }

    public static City fromRequestTo(CityRequest cityRequest) {
        if (cityRequest == null) {
            return null;
        }
        City city = new City();
        city.setCityName(cityRequest.getCityName());
        city.setProvinceId(cityRequest.getProvinceId());
        city.setDescription(cityRequest.getDescription());
        return city;
    }

    @RequestMapping(value = "/test")
    public String test(){
        return "success";
    }



}
