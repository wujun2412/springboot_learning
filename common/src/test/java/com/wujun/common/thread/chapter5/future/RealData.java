package com.wujun.common.thread.chapter5.future;

import java.util.concurrent.Callable;

/**
 * @author wujun
 * @description
 * @date 19/4/9.
 */
public class RealData implements Callable {
    private String param;

    public RealData(String param) {
        this.param = param;
    }

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(param);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
        return sb.toString();
    }
}
