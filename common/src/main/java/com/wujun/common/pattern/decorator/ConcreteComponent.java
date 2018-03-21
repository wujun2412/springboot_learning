package com.wujun.common.pattern.decorator;

/**
 * @author wujun
 * @description 具体实现
 * @date 18/3/19.
 */
public class ConcreteComponent implements Component{
    @Override
    public void say(String str) {
        System.out.println("say:"+str);
    }
}
