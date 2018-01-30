package com.wujun.boot.service.impl;

import com.wujun.boot.dao.cluster.UserMapper;
import com.wujun.boot.dao.master.CityMapper;
import com.wujun.boot.domain.City;
import com.wujun.boot.domain.User;
import com.wujun.boot.domain.ext.UserExt;
import com.wujun.boot.service.UserService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author wujun
 * @description
 * @date 18/1/30.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private DozerBeanMapper dozerMapper;

    @Override
    public UserExt findByName(String userName) {
        List<User> users = userMapper.selectByName(userName);
        UserExt user = null;
        if (!CollectionUtils.isEmpty(users)){
            user = dozerMapper.map(users.get(0),UserExt.class);
            City city = cityMapper.selectByPrimaryKey(user.getCityId());
            user.setCity(city);
        }
        return user;
    }
}
