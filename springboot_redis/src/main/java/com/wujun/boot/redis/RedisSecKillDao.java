package com.wujun.boot.redis;

import com.alibaba.fastjson.JSON;
import com.wujun.common.core.exception.XExceptionFactory;
import com.wujun.common.core.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.util.SafeEncoder;

/**
 * @author wujun
 * @description 秒杀扣库存，配合减库存是否成功，判断秒杀是否成功
 * @date 19/1/23.
 */
@Service
public class RedisSecKillDao {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String CAN_BUY_PREFIX = "com:wujun:seckill:can:buy:";

    public Integer secKill(final String storeKey) {
        return (Integer) redisTemplate.execute(new RedisCallback() {
            @Override
            public Integer doInRedis(RedisConnection connection) {
                System.out.println("秒杀中。。。。。");
                Integer ret = 0;
                connection.watch(storeKey.getBytes());
                Integer remain = get(storeKey,connection);
                if (remain <= 0){
                    throw XExceptionFactory.create("ERROR_SECOND_KILL_0001","");
                }
                connection.multi();
                String canBuyKey = CAN_BUY_PREFIX + RandomUtils.randomInt(8);
                String canBuyValue = "1";
                connection.set(canBuyKey.getBytes(), canBuyValue.getBytes());
                // 扣库存
                connection.decrBy(SafeEncoder.encode(storeKey), 1);
                connection.exec();

                byte[] bytes = connection.get(canBuyKey.getBytes());
                if (bytes != null && canBuyValue.equals(new String(bytes))) {
                    ret = 1;
                    connection.del(canBuyKey.getBytes());
                }
                return ret;
            }
        }, true);
    }

    private Integer get(final String storeKey, RedisConnection connection){
        byte[] valueBytes = connection.get(SafeEncoder.encode(storeKey));
        if (valueBytes ==null || valueBytes.length==0){
            return null;
        }
        String value = SafeEncoder.encode(valueBytes);
        Integer remain = JSON.parseObject(value, Integer.class);
        return remain;
    }

}
