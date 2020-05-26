package com.wujun.boot.controller;

import com.wujun.boot.configuration.DlxRabbitConfig;
import com.wujun.boot.configuration.sender.MessageProvider;
import com.wujun.boot.domain.MqMessage;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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

    @Autowired
    private MessageProvider messageProvider;

    @RequestMapping("/test")
    public void sendMessage(@RequestParam String orderNo) {
        MqMessage mqMessage = new MqMessage();
        mqMessage.setDelaySec(10);
        mqMessage.setCallBackUrl("http://localhost:28080/callback");
        Map<String, Object> params = new HashMap<>(8);
        params.put("name","小李");
        mqMessage.setParams(params);
        messageProvider.sendMessage(mqMessage);
    }

}
