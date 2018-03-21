package com.wujun.common.pattern.bridge;

/**
 * @author wujun
 * @description
 * @date 18/3/21.
 */
public abstract class Abstraction {
    private Implementor implementor;

    public Implementor getImplementor() {
        return implementor;
    }

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    public void run(){
        this.implementor.operation();
    }
}
