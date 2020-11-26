package com.wujun.boot.mq.producer;

import com.alibaba.fastjson.JSON;
import com.wujun.boot.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @Author: Jun.Wu
 * @Date: 2020/11/25 10:31
 * @Description:
 */
@Component
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //发送消息方法
    public void send() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("+++++++++++++++++++++  message = {}", JSON.toJSONString(message));
        //test_apisix_mirror为主题
        kafkaTemplate.send("test_apisix_mirror", JSON.toJSONString(message));
    }


}
