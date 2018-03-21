package com.wujun.common.pattern.bridge;

/**
 * @author wujun
 * @description
 * @date 18/3/21.
 */
public class ConcreteImplementorB extends Implementor {
    @Override
    public void operation() {
        System.out.println("具体实现类B的方法执行");
    }
}
