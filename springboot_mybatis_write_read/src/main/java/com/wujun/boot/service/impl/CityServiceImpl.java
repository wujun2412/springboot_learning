package com.wujun.boot.service.impl;

import com.wujun.boot.annotation.WriteDataSource;
import com.wujun.boot.dao.CityMapper;
import com.wujun.boot.domain.City;
import com.wujun.boot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 如果需要事务，自行在方法上添加@Transactional
 * 如果方法有内部有数据库操作，则必须指定@WriteDataSource还是@ReadDataSource
 *
 * 注：AOP ，内部方法之间互相调用时，如果是this.xxx()这形式，不会触发AOP拦截，可能会
 * 导致无法决定数据库是走写库还是读库
 * 方法：
 * 为了触发AOP的拦截，调用内部方法时，需要特殊处理下，看方法getService()
 *
 * @author
 *
 */
@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityMapper cityMapper;


    @Override
    @WriteDataSource
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public Integer saveCity(City city) {
        return cityMapper.insert(city);
    }
}
