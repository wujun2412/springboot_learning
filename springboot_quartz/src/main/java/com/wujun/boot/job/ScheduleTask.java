package com.wujun.boot.job;

import org.springframework.stereotype.Component;

/**
 * @author wujun
 * @description
 * @date 18/12/28.
 */
@Component
public class ScheduleTask {
    public void scheduleTest() {
        System.err.println("scheduleTest开始定时执行");
    }
}
