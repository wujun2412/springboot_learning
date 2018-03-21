package com.wujun.common.pattern.bridge;

/**
 * @author wujun
 * @description
 * @date 18/3/21.
 */
public class RefinedAbstraction extends Abstraction {

    @Override
    public void run() {
        this.getImplementor().operation();
    }
}
