package com.wujun.boot.indicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author wujun
 * @description
 * @date 18/3/1.
 */
@Component
public class RocketMQHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = check();
        if (errorCode!=0){
            return Health.down().withDetail("Error code",errorCode).build();
        }
        return Health.up().build();
    }

    private int check(){
        //对监控对象的监测操作
        return 1;
    }
}
