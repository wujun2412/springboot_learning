package com.wujun.common.pattern.responsibility;

/**
 * @author wujun
 * @description
 * @date 18/3/21.
 */
public class Test {

    public static void main(String[] args) {
        Request request = new Request("请假","请假",3);
        Manager jingli = new CommonManager("经理");
        Manager zongjian = new Majordomo("总监");
        Manager zongjingli = new Generalmanager("总经理");
        jingli.setSuperior(zongjian);
        zongjian.setSuperior(zongjingli);
        jingli.handleRequest(request);

        Request request1 = new Request("加薪","加薪",500);
        jingli.handleRequest(request1);
        Request request2 = new Request("加薪","加薪",1000);
        jingli.handleRequest(request2);

    }

}
