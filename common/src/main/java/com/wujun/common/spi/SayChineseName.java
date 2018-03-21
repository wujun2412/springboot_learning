package com.wujun.common.spi;

/**
 * @author wujun
 * @description
 * @date 18/3/13.
 */
public class SayChineseName implements ISayName{
    @Override
    public void sayHello(String str) {
        System.out.println("chinese:"+str);
    }
}
