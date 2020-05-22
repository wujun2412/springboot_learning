package com.wujun.boot.configuration;

import com.wujun.boot.constants.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
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

    private static final String ORDER_DEAD_LETTER_QUEUE_KEY = "x-dead-letter-exchange";
    private static final String ORDER_DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";

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
    public static final String DEAD_ROUTING_KEY ="DL_KEY";

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
    public static final String DEAD_REDIRECT_ROUTING_KEY ="RED_KEY";

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
        args.put(ORDER_DEAD_LETTER_QUEUE_KEY, DEAD_LETTER_REDIRECT_EXCHANGE);
        // 出现dead letter之后将dead letter重新按照指定的routing-key发送
        args.put(ORDER_DEAD_LETTER_ROUTING_KEY, DEAD_REDIRECT_ROUTING_KEY);
        return new Queue(DEAD_LETTER_QUEUE, true, false, false, args);
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

    @Bean("deadLetterRedirectQueue")
    public Queue deadLetterRedirectQueue() {
        return new Queue(QueueEnum.DEAD_LETTER_REDIRECT_QUEUE.getQueueName(), true, false, false);
    }

    @Bean
    public Binding deadLetterBinding() {
        return new Binding(DEAD_LETTER_QUEUE, Binding.DestinationType.QUEUE, DEAD_LETTER_EXCHANGE, DEAD_ROUTING_KEY, null);
    }

    @Bean
    public Binding orderRedirectBinding() {
        return new Binding(DEAD_LETTER_REDIRECT_QUEUE, Binding.DestinationType.QUEUE, DEAD_LETTER_REDIRECT_EXCHANGE, DEAD_REDIRECT_ROUTING_KEY, null);
    }

}
