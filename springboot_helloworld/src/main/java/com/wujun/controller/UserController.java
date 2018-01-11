package com.wujun.controller;

import com.wujun.entities.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author wujun
 * @description
 * @date 18/1/9.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    static Map<Long,User> users = Collections.synchronizedMap(new HashMap<>());

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> list = new ArrayList<>(users.values());
        return list;
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user){
        if (!Objects.isNull(user)){
            if (!Objects.isNull(user.getId())){
                users.put(user.getId(),user);
            }
        }
        return "success";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUse(@PathVariable("id") Long id){
        return users.get(id);
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public String updateUser(@PathVariable("id") Long id,@ModelAttribute User user){
        User u= users.get(id);
        u.setName(user.getName());
        u.setSex(user.getSex());
        users.put(id,u);
        return "success";
    }

    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public String delUser(@PathVariable("id") Long id){
        users.remove(id);
        return "success";
    }
}
