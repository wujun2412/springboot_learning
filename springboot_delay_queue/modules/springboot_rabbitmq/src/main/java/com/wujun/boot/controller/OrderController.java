package com.wujun.boot.controller;

import com.wujun.boot.configuration.DlxRabbitConfig;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * @Author: Jun.Wu
 * @Date: 2020/5/16 14:56
 * @Description:
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/test")
    public void sendMessage(@RequestParam String orderNo) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        //生成一个消息的唯一id，不选
        //声明消息处理器，设置消息的编码以及消息的过期时间，时间毫秒值为字符串
        MessagePostProcessor messagePostProcessor = message -> {
            MessageProperties messageProperties = message.getMessageProperties();
            //设置编码
            messageProperties.setContentEncoding("utf-8");
            //设置过期时间2分钟
            int expiration = 1000 * 60 * 1;
            messageProperties.setExpiration(String.valueOf(expiration));
            return message;
        };
        // 向ORDER_DL_EXCHANGE发送消息，形成死信， 在OrderQueueReceiver类处理死信交换机转发队列的信息
        rabbitTemplate.convertAndSend(DlxRabbitConfig.DEAD_LETTER_EXCHANGE, DlxRabbitConfig.DEAD_ROUTING_KEY, orderNo, messagePostProcessor, correlationData);
        System.out.println(new Date() + "发送消息，订单号为：" + orderNo);
    }

}
