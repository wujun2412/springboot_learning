package com.wujun.boot.dao.cluster;

import com.wujun.boot.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectByName(@Param("name") String name);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}