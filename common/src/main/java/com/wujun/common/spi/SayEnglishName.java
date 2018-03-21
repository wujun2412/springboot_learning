package com.wujun.common.spi;

/**
 * @author wujun
 * @description
 * @date 18/3/13.
 */
public class SayEnglishName implements ISayName {
    @Override
    public void sayHello(String str) {
        System.out.println("english:"+str);
    }
}
