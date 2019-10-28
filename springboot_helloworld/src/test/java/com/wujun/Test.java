package com.wujun;

import com.alibaba.fastjson.JSON;
import com.wujun.entities.User;

import java.lang.reflect.ParameterizedType;

/**
 * @Author: Jun.Wu
 * @Date: 2019-10-17 09:30
 * @Description:
 */
public class Test<T> {
    public Class<T> getTClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void test() {
        System.out.println(getTClass());
    }

    public T toObj(String str){
        return JSON.parseObject(str, (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    public static void main(String args[]) {
        User user = new User(1L,"test",1);
        String str = JSON.toJSONString(user);
        Test<User> test = new Test<User>(){};
        User user2 = test.toObj(str);
        System.out.println(user2);
        test.test();
        System.out.println(test.getClass().getGenericSuperclass());
        //(new Test<User>() {}).test(); // class java.lang.String
    }


}
