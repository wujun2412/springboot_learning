package com.wujun.common.pattern.responsibility;

/**
 * @author wujun
 * @description
 * @date 18/3/21.
 */
public class Generalmanager extends Manager {

    public Generalmanager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(Request request) {
        if ("请假".equals(request.getType())){
            System.out.printf("%s:%s 数量%d被批准\n",name,request.getContent(),request.getNum());
        }else if("加薪".equals(request.getType())&&request.getNum()<=500){
            System.out.printf("%s:%s 数量%d被批准\n",name,request.getContent(),request.getNum());
        }else if ("加薪".equals(request.getType())&&request.getNum()>500){
            System.out.printf("%s:%s 数量%d再说吧\n",name,request.getContent(),request.getNum());
        }

    }
}
