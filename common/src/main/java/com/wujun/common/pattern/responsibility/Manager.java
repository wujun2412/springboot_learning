package com.wujun.common.pattern.responsibility;

/**
 * @author wujun
 * @description
 * @date 18/3/21.
 */
public abstract class Manager {
    protected String name;

    /**
     * 管理者的上级
     */
    protected Manager superior;

    public Manager(String name) {
        this.name = name;
    }

    public Manager getSuperior() {
        return superior;
    }

    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    public abstract void handleRequest(Request request);


}
