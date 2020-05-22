package com.wujun.boot.configuration.sender;

import com.wujun.boot.domain.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author wujun
 * @description
 * @date 19/5/9.
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplete;

    public void send() {
        String context = "hello" + new Date();
        System.out.println("Sender : "+ context);
        this.rabbitTemplete.convertAndSend("hello",context);
    }


    public void send(int obj) {
        System.out.println("Sender : "+ obj);
        this.rabbitTemplete.convertAndSend("hello",obj);
    }


    //发送对象
    public void send(User user){
        System.out.println("Sending object : " + user.toString());
        rabbitTemplete.convertAndSend("object",user);
    }

    /**
     * tipic 类型消息
     */
    public void topicSend1(){
        String content = "hi, i am message 1";
        System.out.println("topicSender1 : "+ content);
        rabbitTemplete.convertAndSend("exchange","topic.message",content);
    }

    public void topicSend2(){
        String content = "hi, i am message 2";
        System.out.println("topicSender2 : "+ content);
        rabbitTemplete.convertAndSend("exchange","topic.messages",content);
    }

    /**
     * fanout 类型消息
     */
    public void fanoutSend(){
        String content = "hi, i am fanout message";
        System.out.println("fanoutSender : "+ content);
        rabbitTemplete.convertAndSend("fanoutExchange","",content);
    }

    /**
     * direct 类型消息
     */
    public void directSend1(){
        String content = "hi, i am direct message";
        System.out.println("directSender1 : "+ content);
        rabbitTemplete.convertAndSend("directExchange","direct.error",content);
    }

    public void directSend2(){
        String content = "hi, i am direct message";
        System.out.println("directSender2 : "+ content);
        rabbitTemplete.convertAndSend("directExchange","direct.info",content);
    }
}
