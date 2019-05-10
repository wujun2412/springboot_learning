package com.wujun.boot.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wujun
 * @description
 * @date 19/5/10.
 */
@Configuration
public class FanoutRabbitConfig {

    //定义三个消息队列，来测试fanout 类型exchange
    final static String messageA = "fanout.A";
    final static String messageB = "fanout.B";
    final static String messageC = "fanout.C";

    @Bean
    public Queue aMessage(){
        return new Queue(FanoutRabbitConfig.messageA);
    }

    @Bean
    public Queue bMessage(){
        return new Queue(FanoutRabbitConfig.messageB);
    }

    @Bean
    public Queue cMessage(){
        return new Queue(FanoutRabbitConfig.messageC);
    }

    /**
     * 定义Fanout 类型exchange
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * Fanout exchange与队列绑定
     */
    @Bean
    Binding bindingFanoutExchangeA(Queue aMessage, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(aMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingFanoutExchangeB(Queue bMessage, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(bMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingFanoutExchangeC(Queue cMessage, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(cMessage).to(fanoutExchange);
    }

}
