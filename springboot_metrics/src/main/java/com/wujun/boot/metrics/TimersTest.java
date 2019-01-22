package com.wujun.boot.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author wujun
 * @description Timer其实是 Histogram 和 Meter 的结合， histogram 某部分代码/调用的耗时， meter统计TPS。
 * @date 19/1/22.
 */
public class TimersTest {

    private static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        MetricRegistry registory = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registory).build();
        reporter.start(1, TimeUnit.SECONDS);
        Timer timer = registory.timer(MetricRegistry.name(TimersTest.class,"get-latency"));
        Timer.Context ctx;
        while (true){
            ctx = timer.time();
            Thread.sleep(random.nextInt(1000));
            ctx.stop();
        }
    }

}
