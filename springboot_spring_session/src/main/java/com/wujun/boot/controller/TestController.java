package com.wujun.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wujun
 * @description
 * @date 19/1/7.
 */
@RestController
public class TestController {

    @RequestMapping(value = "/session")
    public Map<String, Object> getSession(HttpServletRequest request) {
        request.getSession().setAttribute("username", "admin");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sessionId", request.getSession().getId());
        return map;
    }

    @RequestMapping(value = "/get")
    public String get(HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("username");

        return userName;
    }


}
