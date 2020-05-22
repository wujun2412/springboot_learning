package com.wujun.boot.configuration.receiver;

import com.rabbitmq.client.Channel;
import com.wujun.boot.configuration.DlxRabbitConfig;
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
public class OrderMessageReceiver {

    @RabbitListener(queues = {DlxRabbitConfig.DEAD_LETTER_REDIRECT_QUEUE})
    @RabbitHandler
    public void process(Message message,
                        Channel channel) throws IOException {

        //从队列中取出订单号
        byte[] body = message.getBody();
        String orderNo = new String(body, "UTF-8");
        System.out.println(new Date() + "消费消息，订单号为"
                + orderNo);
        //确认消息有没有被收到,false表示手动确认 在处理完消息时，返回应答状态
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);


    }

}
