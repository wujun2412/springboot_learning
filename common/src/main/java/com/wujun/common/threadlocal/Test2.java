package com.wujun.common.threadlocal;

import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

/**
 * @author wujun
 * @description
 * @date 18/1/29.
 */
public class Test2 {

//    public static void main(String[] args) {
////        int value;
////        boolean initialValue = true;
////        System.out.println(value = initialValue ? 1 : 0);
//        IntBinaryOperator i = (x,y)->x*y;
//        System.out.println(i.applyAsInt(3,2));
//        function();
//    }
//
//    public static void function(){
//        IntUnaryOperator i = (x)->x*x;
//        System.out.println(i.applyAsInt(3));
//    }

    private static Stack<Integer> iStack = new Stack<>();

    public static synchronized Integer getI() {
        return iStack.peek();
    }

    public static synchronized void setI(Integer i) {
        iStack.push(i);
    }

    static IntUnaryOperator intUnaryOperator = new IntUnaryOperator() {
        @Override
        public int applyAsInt(int operand) {
            int ret = operand+1;
             //   int ret = operand + getI();
            setI(ret);
            return ret;
        }
    };

    static IntUnaryOperator nonSideEffectFreeIntUnaryOperator = new IntUnaryOperator() {
        @Override
        public int applyAsInt(int operand) {
//                int ret = operand+1;
            int ret = operand + getI();
            setI(ret);
            return ret;
        }
    };

    public static void main(String[] args) {
        iStack.push(1);

        //runBiz(intUnaryOperator);

        runBiz(nonSideEffectFreeIntUnaryOperator);

    }

    private static void runBiz(IntUnaryOperator intUnaryOperator) {
        AtomicInteger atomicInteger = new AtomicInteger(1);

        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 4; j++) {
                    System.out.println(atomicInteger.getAndUpdate(intUnaryOperator));
                }
            });
        }
    }

}
