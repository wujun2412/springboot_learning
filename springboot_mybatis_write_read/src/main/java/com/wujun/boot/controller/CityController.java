package com.wujun.boot.controller;

import com.wujun.boot.domain.City;
import com.wujun.boot.requests.CityRequest;
import com.wujun.boot.responses.ApiResult;
import com.wujun.boot.service.CityService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujun
 * @description
 * @date 18/1/19.
 */
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private DozerBeanMapper dozerMapper;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }



    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ApiResult saveCity(@RequestBody CityRequest cityRequest){
        City city = dozerMapper.map(cityRequest,City.class);
        try {
            cityService.saveCity(city);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResult.SUCCESS();
    }


    @ApiOperation(value = "获取的用户信息")
    @ApiImplicitParam(name = "id",value = "用户ID",required = true,dataType = "Integer")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ApiResult findCity(@RequestParam("id") Integer id){
        City city = cityService.findById(id);
        ApiResult<City> result = new ApiResult<>();
        result.setData(city);
        return result;
    }

}
