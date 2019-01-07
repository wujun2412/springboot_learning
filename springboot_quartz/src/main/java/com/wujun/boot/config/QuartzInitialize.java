package com.wujun.boot.config;

import com.wujun.boot.job.MyJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wujun
 * @description
 * @date 19/1/2.
 */
@Component
public class QuartzInitialize implements CommandLineRunner {

    @Resource(name="multitaskScheduler")
    private Scheduler scheduler;

    @Override
    public void run(String... args) throws Exception {
        scheduleJob(scheduler);
    }

    private void scheduleJob(Scheduler scheduler) throws SchedulerException {
        //配置定时任务对应的Job，这里执行的是ScheduledJob2类中定时的方法
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class) .withIdentity("job1", "group1").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        // 每6s执行一次
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1") .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
        scheduler.start();
    }

}
