package com.wujun.distribute;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Objects;

/**
 * @author wujun
 * @description
 * @date 18/1/15.
 */
public class Service {
    private static JedisPool pool = null;
    private DistributeLock lock = new DistributeLock(pool);

    int n = 500;
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大连接数
        config.setMaxTotal(200);
        //设置最大空闲数
        config.setMaxIdle(8);
        //设置最大等待时间
        config.setMaxWaitMillis(1000*100);
        //在borrow一个jedis实例时，是否需要验证，若为true，则所有jedis实例钧是可用的
        config.setTestOnBorrow(true);
        pool = new JedisPool(config,"127.0.0.1",6379,300);
    }

    public void seckill(){
        //返回锁的value值，供释放锁时候进行判断
        String identifier = lock.lockWithTimeout("resource",1000,1000);
        System.out.println(Thread.currentThread().getName()+"获得了锁:"+identifier);
        System.out.println(--n);
        if (Objects.nonNull(identifier)){
            lock.releaseLock("resource",identifier);
        }

    }
}
