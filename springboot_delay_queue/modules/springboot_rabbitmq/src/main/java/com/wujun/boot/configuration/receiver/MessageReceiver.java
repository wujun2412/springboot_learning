package com.wujun.boot.configuration.receiver;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.wujun.boot.constants.Action;
import com.wujun.boot.constants.MqConstants;
import com.wujun.boot.domain.MqMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * @Author: Jun.Wu
 * @Date: 2020/5/16 15:12
 * @Description:
 */
@Component
public class MessageReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceiver.class);


    @RabbitListener(queues = {MqConstants.DEAD_LETTER_REDIRECT_QUEUE})
    @RabbitHandler
    public void process(MqMessage mqMessage, Channel channel,
                        Message message) throws IOException {

        //从队列中取出订单号
        //String msgStr = new String(message.getBody(), "UTF-8");
        String msgStr = JSON.toJSONString(mqMessage);
        LOGGER.info("{}消费消息,msg={}", new Date(), msgStr);
        //MqMessage mqMessage = JSON.parseObject(msgStr, MqMessage.class);
        Action action = Action.RETRY;
        try {
            // TODO 执行回调
            LOGGER.info("[MessageConsumer延时消息消费时间]{}，消息={}", new Date(), msgStr);
            action = Action.ACCEPT;
        } catch (Exception e) {
            LOGGER.error("消息确认异常:{}", e);
            // 记录异常消息到redis
            action = Action.RETRY;
        } finally {
            // 通过finally块来保证ack/nack会且只会执行一次
            if (action == Action.ACCEPT) {
                //确认消息有没有被收到,false表示手动确认 在处理完消息时，返回应答状态
                //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } else if (action == Action.RETRY) {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            } else {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            }
        }


    }

}
