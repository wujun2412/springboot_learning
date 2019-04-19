package com.wujun.common.thread.chapter6.function;

/**
 * @author wujun
 * @description
 * @date 19/4/10.
 */
@FunctionalInterface
public interface IntHandler {
    void handle(int i);
    boolean equals(Object obj);
    String toString();
}
