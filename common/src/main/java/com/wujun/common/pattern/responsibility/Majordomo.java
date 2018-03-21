package com.wujun.common.pattern.responsibility;

/**
 * @author wujun
 * @description
 * @date 18/3/21.
 */
public class Majordomo extends Manager {

    public Majordomo(String name) {
        super(name);
    }

    @Override
    public void handleRequest(Request request) {
        if ("请假".equals(request.getType())&&request.getNum()<=5){
            System.out.printf("%s:%s 数量%d被批准\n",name,request.getContent(),request.getNum());
        }else{
            if (superior!=null){
                superior.handleRequest(request);
            }
        }
    }
}
