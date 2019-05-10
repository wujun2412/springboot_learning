package com.wujun.boot.configuration;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wujun
 * @description
 * @date 19/5/9.
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitHandler
    public void process(Integer hello) {
        System.out.println("Receiver1  : " + hello);
    }

}
