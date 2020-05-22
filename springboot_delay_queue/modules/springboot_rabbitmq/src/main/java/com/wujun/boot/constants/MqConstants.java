package com.wujun.boot.constants;

/**
 * @Author: Jun.Wu
 * @Date: 2020/5/22 10:54
 * @Description: mq常量类，用于定义交换机、队列、路由key的名称
 */
public class MqConstants {

    /**
     * 死信交换机
     */
    public static final String DEAD_LETTER_EXCHANGE = "ORDER_DL_EXCHANGE";
    /**
     * 死信队列
     */
    public static final String DEAD_LETTER_QUEUE = "ORDER_DL_QUEUE";
    /**
     * 死信路由
     */
    public static final String DEAD_ROUTING_KEY ="ORDER_DL_KEY";

    /**
     * 死信重定向交换机
     */
    public static final String DEAD_LETTER_REDIRECT_EXCHANGE = "ORDER_DL_REDIRECT_EXCHANGE";
    /**
     * 死信重定向队列
     */
    public static final String DEAD_LETTER_REDIRECT_QUEUE = "ORDER_REDIRECT_QUEUE";

    /**
     * 死信重定向路由
     */
    public static final String DEAD_REDIRECT_ROUTING_KEY ="ORDER_REDIRECT_KEY";



}
