package com.wujun.boot.configuration.sender;

import com.alibaba.fastjson.JSON;
import com.wujun.boot.constants.QueueEnum;
import com.wujun.boot.domain.MqMessage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Author: Jun.Wu
 * @Date: 2020/5/23 15:54
 * @Description:
 */
@Component
public class MessageProvider implements RabbitTemplate.ConfirmCallback {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageProvider.class);

    @Autowired
    private RabbitTemplate rabbitTemplete;

    private String msgPojoStr;

    public void sendMessage(MqMessage message) {
        if (message != null) {
            if (StringUtils.isEmpty(message.getCallBackUrl())) {
                LOGGER.error("业务回调URL不能为空!");
                return;
            }
            message.setMessageId(UUID.randomUUID().toString());
            message.setCreateTime(String.valueOf(System.currentTimeMillis()));
            msgPojoStr = JSON.toJSONString(message);
            // 发送消息到指定队列
            CorrelationData correlationData = new CorrelationData(message.getMessageId());
            rabbitTemplete.convertAndSend(QueueEnum.DEAD_LETTER_QUEUE.getExchangeName(), QueueEnum.DEAD_LETTER_QUEUE.getRouteKey(), message, msg -> {
                //设置延迟毫秒值
                msg.getMessageProperties().setExpiration(String.valueOf(message.getDelaySec() * 1000));
                return msg;
            }, correlationData);
        } else {
            LOGGER.error("消息内容为空!!!!!!");
        }
    }


    /**
     * 发送确认
     *
     * @param correlationData
     * @param b
     * @param s
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        LOGGER.info("回调id:{}", correlationData.toString());
        if (b) {
            LOGGER.info("消息发送成功:{}", msgPojoStr);
        } else {
            LOGGER.error("消息发送失败,msg={},reason={}", msgPojoStr, s);
        }
    }
}
