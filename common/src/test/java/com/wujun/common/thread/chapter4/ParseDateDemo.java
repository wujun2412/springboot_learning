package com.wujun.common.thread.chapter4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wujun
 * @description
 * @date 19/4/1.
 */
public class ParseDateDemo {
//    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

    private static class ParseDate implements Runnable {
        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                if (threadLocal.get()==null){
                    threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
                Date d = threadLocal.get().parse("2019-04-01 11:59:" + i % 60);
                System.out.println(i + ":" + d);
                threadLocal.remove();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for(int i =0;i<1000;i++){
            es.execute(new ParseDate(i));
        }
    }
}
