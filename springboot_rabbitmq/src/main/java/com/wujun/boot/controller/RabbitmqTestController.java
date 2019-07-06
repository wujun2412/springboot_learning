package com.wujun.boot.controller;

import com.wujun.boot.configuration.sender.HelloSender;
import com.wujun.boot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujun
 * @description
 * @date 19/5/9.
 */
@RestController
@RequestMapping("/rabbitmq")
public class RabbitmqTestController {
    @Autowired
    private HelloSender helloSender;

    @RequestMapping("/hello")
    public void test(){
        helloSender.send();
    }

    @RequestMapping("/oneToMany")
    public void oneToMany() throws Exception{
        for (int i = 0; i <100; i++) {
            helloSender.send(i);
        }
    }


    @RequestMapping("/sendObject")
    public void sendObject(){
        User user = new User("吴军",30);
        helloSender.send(user);
    }

    // topic exchange模式
    @RequestMapping("/topicSend1")
    public void sendTopic1(){
        helloSender.topicSend1();
    }

    @RequestMapping("/topicSend2")
    public void sendTopic2(){
        helloSender.topicSend2();
    }

    // fanout exchange模式
    @RequestMapping("/fanoutSend")
    public void fanoutSend(){
        helloSender.fanoutSend();
    }


    // direct exchange模式
    @RequestMapping("/directSend1")
    public void directSend1(){
        helloSender.directSend1();
    }

    @RequestMapping("/directSend2")
    public void directSend2(){
        helloSender.directSend2();
    }

}
