package com.wujun.common.test;

import java.lang.reflect.Method;

/**
 * @author wujun
 * @description
 * @date 18/12/27.
 */
public class Test8 {

    public static void main(String[] args) throws NoSuchMethodException {
        /*Map<Long, Integer> map = new HashMap<>(16);
        Long l1 = new Long(1);


        map.put(l1,1);
        System.out.println(map.containsKey(1L));*/

        Method method = Test8.class.getMethod("print", String.class);


    }



    public String print(String str){
        System.out.println(str);
        return str;
    }

}

































