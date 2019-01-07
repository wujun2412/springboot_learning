package com.wujun.boot.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wujun
 * @description
 * @date 18/12/28.
 */
public class MyJob implements Job {
    private static final Logger logger = LoggerFactory.getLogger(MyJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.debug("定时任务执行中。。。。");
    }
}
