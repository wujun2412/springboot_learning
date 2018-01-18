package com.wujun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujun
 * @description
 * @date 18/1/9.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/myservlet")
    public String sayHello(){
        return "Hello World!";
    }

}
