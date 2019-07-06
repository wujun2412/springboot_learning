package com.wujun.boot.configuration.receiver;

import com.wujun.boot.configuration.DirectRabbitConfig;
import com.wujun.boot.configuration.FanoutRabbitConfig;
import com.wujun.boot.configuration.TopicRabbitConfig;
import com.wujun.boot.domain.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wujun
 * @description
 * @date 19/5/9.
 */
@Component
public class HelloReceiver2 {

    @RabbitListener(queues = "hello")
    @RabbitHandler
    public void process(Integer hello) {
        System.out.println("Receiver2  : " + hello);
    }


    @RabbitListener(queues = "object")
    @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver2 object : " + user);
    }

    @RabbitListener(queues = TopicRabbitConfig.message)
    @RabbitHandler
    public void topicProcess1(String content) {
        System.out.println("topicReceiver1 : " + content);
    }

    @RabbitListener(queues = TopicRabbitConfig.messages)
    @RabbitHandler
    public void topicProcess2(String content) {
        System.out.println("topicReceiver2 : " + content);
    }


    @RabbitListener(queues = FanoutRabbitConfig.messageA)
    @RabbitHandler
    public void fanoutProcessA(String content) {
        System.out.println("fanoutReceiverA : " + content);
    }

    @RabbitListener(queues = FanoutRabbitConfig.messageB)
    @RabbitHandler
    public void fanoutProcessB(String content) {
        System.out.println("fanoutReceiverB : " + content);
    }

    @RabbitListener(queues = FanoutRabbitConfig.messageC)
    @RabbitHandler
    public void fanoutProcessC(String content) {
        System.out.println("fanoutReceiverC : " + content);
    }

    /*@RabbitListener(queues = DirectRabbitConfig.message)
    @RabbitHandler
    public void directProcessA(String content){
        System.out.println("directReceiveA : " + content);
    }
*/
    @RabbitListener(queues = DirectRabbitConfig.messages)
    @RabbitHandler
    public void directProcessB(String content){
        System.out.println("directReceiveB : " + content);
    }


}
