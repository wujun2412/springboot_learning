package com.wujun.boot.controller;

import com.wujun.boot.mq.producer.KafkaProducer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujun
 * @description
 * @date 19/5/9.
 */
@Api(tags = {"kafka"}, description = "kafka管理")
@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaTestController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @ApiOperation("发送消息")
    @GetMapping("/send")
    public void test() {
        kafkaProducer.send();
    }

}
