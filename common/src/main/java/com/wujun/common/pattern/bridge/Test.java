package com.wujun.common.pattern.bridge;

/**
 * @author wujun
 * @description
 * @date 18/3/21.
 */
public class Test {

    public static void main(String[] args) {
        Implementor a = new ConcreteImplementorA();
        Implementor b = new ConcreteImplementorB();
        Abstraction abstraction = new RefinedAbstraction();
        abstraction.setImplementor(a);
        abstraction.run();
        abstraction.setImplementor(b);
        abstraction.run();
    }
}
