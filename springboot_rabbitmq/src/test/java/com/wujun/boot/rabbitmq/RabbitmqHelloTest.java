package com.wujun.boot.rabbitmq;

import com.wujun.boot.configuration.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wujun
 * @description
 * @date 19/5/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqHelloTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() throws Exception{
        helloSender.send();

        Thread.sleep(5000);
    }

}
