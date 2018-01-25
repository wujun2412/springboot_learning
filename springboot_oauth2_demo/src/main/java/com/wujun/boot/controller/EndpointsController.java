package com.wujun.boot.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujun
 * @description
 * 暴露一个商品查询接口，后续不做安全限制，一个订单查询接口，后续添加访问控制。
 * @date 18/1/25.
 */
@RestController
public class EndpointsController {

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "product id : "+id;
    }


    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return "oder id : "+ id;
    }
}
