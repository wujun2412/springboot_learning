package com.wujun.boot.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wujun
 * @description
 * @date 19/5/13.
 */
@Configuration
public class DirectRabbitConfig {
    //定义两个消息队列，来测试direct 类型exchange
    public final static String message = "direct.A";
    public final static String messages = "direct.B";

    @Bean
    public Queue directQueueA() {
        /*Map<String, Object> argss = new HashMap<String, Object>();
        argss.put("x-message-ttl", 6000);
        return new Queue(DirectRabbitConfig.message, true, false, false, argss);
        */
        return new Queue(DirectRabbitConfig.message);
    }

    @Bean
    public Queue directQueueB() {
        return new Queue(DirectRabbitConfig.messages);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    /**
     * direct exchange与队列绑定
     */
    @Bean
    Binding bindingDirectExchangeA(Queue directQueueA, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueueA).to(directExchange).with("direct.error");
    }

    @Bean
    Binding bindingDirectExchangeB(Queue directQueueB, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueueB).to(directExchange).with("direct.error");
    }

    @Bean
    Binding bindingDirectExchangeC(Queue directQueueB, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueueB).to(directExchange).with("direct.info");
    }


}
