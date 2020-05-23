package com.wujun.boot.configuration;

import com.wujun.boot.constants.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Jun.Wu
 * @Date: 2020/5/16 14:28
 * @Description: 死信队列
 */
@Configuration
public class DlxRabbitConfig {

    private static final String X_DEAD_LETTER_QUEUE_KEY = "x-dead-letter-exchange";
    private static final String X_DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";

    /**
     * 定义死信交换机(延时消息交换机)
     *
     * @return
     */
    @Bean("deadLetterExchange")
    public Exchange deadLetterExchange() {
        return ExchangeBuilder.directExchange(QueueEnum.DEAD_LETTER_QUEUE.getExchangeName()).durable(true).build();
    }

    /**
     * 定义死信队列
     *
     * @return
     */
    @Bean("deadLetterQueue")
    public Queue deadLetterQueue() {
        Map<String, Object> args = new HashMap<>(2);
        // 出现dead letter之后将dead letter重新发送到指定的exchange
        args.put(X_DEAD_LETTER_QUEUE_KEY, QueueEnum.DEAD_LETTER_REDIRECT_QUEUE.getExchangeName());
        // 出现dead letter之后将dead letter重新按照指定的routing-key发送
        args.put(X_DEAD_LETTER_ROUTING_KEY, QueueEnum.DEAD_LETTER_REDIRECT_QUEUE.getRouteKey());
        return QueueBuilder.durable(QueueEnum.DEAD_LETTER_QUEUE.getQueueName()).withArguments(args).build();
    }

    /**
     * 死信交换机与死信队列绑定
     *
     * @return
     */
    @Bean
    public Binding deadLetterBinding(Exchange deadLetterExchange, Queue deadLetterQueue) {
        return BindingBuilder.bind(deadLetterQueue).to(deadLetterExchange).with(QueueEnum.DEAD_LETTER_QUEUE.getRouteKey()).noargs();
    }

    /**
     * 定义死信重定向交换机
     *
     * @return
     */
    @Bean("deadLetterRedirectExchange")
    public Exchange deadLetterRedirectExchange() {
        return ExchangeBuilder.directExchange(QueueEnum.DEAD_LETTER_REDIRECT_QUEUE.getExchangeName()).durable(true).build();
    }

    /**
     * 定义死信重定向队列
     * @return
     */
    @Bean("deadLetterRedirectQueue")
    public Queue deadLetterRedirectQueue() {
        return QueueBuilder.durable(QueueEnum.DEAD_LETTER_REDIRECT_QUEUE.getQueueName()).build();
    }

    /**
     * 死信重定向交换机与死信重定向队列绑定
     * @param deadLetterRedirectExchange
     * @param deadLetterRedirectQueue
     * @return
     */
    @Bean
    public Binding orderRedirectBinding(Exchange deadLetterRedirectExchange, Queue deadLetterRedirectQueue) {
        return BindingBuilder.bind(deadLetterRedirectQueue).to(deadLetterRedirectExchange).with(QueueEnum.DEAD_LETTER_REDIRECT_QUEUE.getRouteKey()).noargs();
    }

}
