package com.wujun.boot.constants;

/**
 * @Author: Jun.Wu
 * @Date: 2020/5/22 11:01
 * @Description: 消息队列枚举值(交换机 、 队列 、 路由键绑定关系)
 */
public enum QueueEnum {
    /**
     * 死信队列
     */
    DEAD_LETTER_QUEUE(MqConstants.DEAD_LETTER_EXCHANGE, MqConstants.DEAD_LETTER_QUEUE, MqConstants.DEAD_LETTER_ROUTING_KEY),

    /**
     * 死信重定向队列
     */
    DEAD_LETTER_REDIRECT_QUEUE(MqConstants.DEAD_LETTER_REDIRECT_EXCHANGE, MqConstants.DEAD_LETTER_REDIRECT_QUEUE, MqConstants.DEAD_LETTER_REDIRECT_ROUTING_KEY);

    /**
     * 交换机名称
     */
    private String exchangeName;

    /**
     * 队列名称
     */
    private String queueName;

    /**
     * 路由键名称
     */
    private String routeKey;

    QueueEnum(String exchangeName, String queueName, String routeKey) {
        this.exchangeName = exchangeName;
        this.queueName = queueName;
        this.routeKey = routeKey;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getRouteKey() {
        return routeKey;
    }

    public void setRouteKey(String routeKey) {
        this.routeKey = routeKey;
    }
}
