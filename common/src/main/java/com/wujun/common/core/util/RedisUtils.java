package com.wujun.common.core.util;

import com.alibaba.fastjson.JSON;
import com.wujun.common.core.context.ApplicationContextStaticProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.BuilderFactory;
import redis.clients.util.SafeEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wujun
 * @description
 * @date 18/2/6.
 */
public class RedisUtils {
    private static final Logger logger = LoggerFactory.getLogger(RedisUtils.class);

//    private static RedisTemplate template = ApplicationContextStaticProvider.getApplicationContext().getBean("redisTemplate",RedisTemplate.class);

    private static RedisTemplate template = ApplicationContextStaticProvider.getApplicationContext().getBean("redisTemplate", RedisTemplate.class);

    /**
     * put object to redis,key exist by default time(1h)
     *
     * @param key
     * @param value
     */
    public static void put(final String key, final Object value) {
        put(key, value, 60 * 60);
    }

    /**
     * put object to redis,key exist by set time
     *
     * @param key
     * @param value
     * @param seconds
     */
    public static void put(final String key, final Object value, final Integer seconds) {
        if (value == null) {
            remove(key);
            return;
        }
        template.execute((RedisCallback) connection -> {
            String json = JSON.toJSONString(value);
            byte[] keyBytes = SafeEncoder.encode(key);
            connection.set(keyBytes, SafeEncoder.encode(json));
            if (seconds > 0) {
                connection.expire(keyBytes, seconds);
            }
            logger.debug("setObject key={},value={}", key, json);
            return null;
        });
    }

    /**
     * get object by key
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T get(final String key,final Class<T> clazz){
        return (T) template.execute((RedisCallback) connection -> {
            byte[] keyBytes = SafeEncoder.encode(key);
            byte[] valueBytes = connection.get(keyBytes);
            if (valueBytes ==null || valueBytes.length==0){
                return null;
            }
            String value = SafeEncoder.encode(valueBytes);
            return JSON.parseObject(value,clazz);
        });
    }

    /**
     * remove object by key
     * @param key
     * @return
     */
    public static Long remove(final String key){
        logger.debug("removeObject:{}",key);
        return (Long) template.execute((RedisCallback) connection -> connection.del(SafeEncoder.encode(key)));
    }

    /**
     * get key exist time
     * @param key
     * @return
     */
    public static Long ttl(final String key){
        return (Long) template.execute((RedisCallback) connection -> connection.ttl(SafeEncoder.encode(key)));
    }

    /**
     * 设置此key的生存时间，单位秒(s)
     */
    public static void setExpire(final String key, final int seconds) {
        logger.debug("set key={} expire time={}s", key, seconds);
        template.execute((RedisConnection connection) -> connection.expire(SafeEncoder.encode(key), seconds));
    }

    /**
     * 设置过期的日期时间。
     *
     * @param key  键
     * @param date 过期的日期与时间
     */
    public static void setExpireAt(final String key, final Date date) {
        int expireTime = DateUtils.getSecondsBetween(new Date(), date);
        setExpire(key, expireTime);
        logger.debug("set key={} expire at datetime={}", key, date.toString());
    }


    //******************以下保存对象采用序列化机制,json形式有很多限制********************

    /**
     * 在指定key的置顶域中设置value
     */
    public static void hput(final String key, final String field, final Object value) {
        logger.debug("set value to field={},key={}", field, key);
        template.execute((RedisConnection connection) -> connection.hSet(SafeEncoder.encode(key), SafeEncoder.encode(field), SerializeUtils.serialize(value)));
    }

    /**
     * 获取指定key中的指定field中的value
     */
    @SuppressWarnings("unchecked")
    public static <T> T hget(final String key, final String field, final Class<T> clazz) {
        return (T) template.execute((RedisConnection connection) -> {
            byte[] value = connection.hGet(SafeEncoder.encode(key), SafeEncoder.encode(field));
            logger.debug("hget value from key={},fiedl={}", key, field);
            if (value == null || value.length == 0) {
                return null;
            }
            return (T) SerializeUtils.unserialize(value);
        });
    }

    /**
     * 移除指定key中的指定field
     */
    public static void hremove(final String key, final String field) {
        logger.debug("gremove value from key={},field={}", key, field);
        template.execute((RedisConnection connection) -> connection.hDel(SafeEncoder.encode(key), SafeEncoder.encode(field)));
    }

    /**
     * 获取key集合中所有相关的value
     */
    @SuppressWarnings("unchecked")
    public static <T> Collection<T> hgetAll(final String key, final Class<T> clazz) {
        return (Collection<T>) template.execute((RedisConnection connection) -> {
            List<T> values = new ArrayList<T>();
            Map<byte[], byte[]> map = connection.hGetAll(SafeEncoder.encode(key));
            for (Map.Entry<byte[], byte[]> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getKey().length > 0 && entry.getValue() != null && entry.getValue().length > 0) {
                    values.add((T) SerializeUtils.unserialize(entry.getValue()));
                }
            }
            logger.debug("hget all value from key={}", key);
            return values;
        });
    }

    public static Long rpush(final String key, final String... value) {
        logger.debug("rpush value with key={},field={}", key, value);
        return (Long) template.execute((RedisConnection connection) -> connection.rPush(SafeEncoder.encode(key), SafeEncoder.encodeMany(value)));
    }

    /**
     * 获取rpush中的数据，start下标从0开始，end为-1时，表示最后一个元素
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<String> lrange(final String key, final int start, final int end) {
        return (List<String>) template.execute((RedisConnection connection) -> {
            List<byte[]> list = connection.lRange(SafeEncoder.encode(key), start, end);
            return BuilderFactory.STRING_LIST.build(list);
        });
    }

    /**
     * 删除rpush中的数据，其中count为0的话，删除所有。假如为-2，则删除从后往前的2个value，为2则从前往后的2个value
     *
     * @param key
     * @param value
     * @param count
     * @return
     */
    public static Long lrem(final String key, final String value, final int count) {
        return (Long) template.execute((RedisConnection connection) -> connection.lRem(SafeEncoder.encode(key), count, SafeEncoder.encode(value)));
    }

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    public static Boolean exists(final String key) {
        logger.debug("query exist key={}", key);
        return (Boolean) template.execute((RedisConnection connection) -> connection.exists(SafeEncoder.encode(key)));
    }

    /**
     * 原子增加key的值+1，如果key不存在，则创建并赋值为1。如果存在值但不是integer类型的则会报错
     *
     * @param key 键
     * @return 返回原子+1后的数值
     */
    public static Long incr(final String key) {
        logger.debug("incrBy key={}", key);
        return (Long) template.execute((RedisConnection connection) -> connection.incr(SafeEncoder.encode(key)));
    }

    /**
     * 原子增加key的值+num
     *
     * @param key 键
     * @param num 原子增加的数量
     * @return 返回原子+num后的数值
     */
    public static Long incrBy(final String key, final long num) {
        logger.debug("incrBy key={},num={}", key, num);
        return (Long) template.execute((RedisConnection connection) -> connection.incrBy(SafeEncoder.encode(key), num));
    }

    /**
     * 原子增加key的值+num
     *
     * @param key 键
     * @param num 原子增加的数量
     * @return 返回原子+num后的数值
     */
    public static Double incrByFloat(final String key, final double num) {
        logger.debug("incrByFloat key={},num={}", key, num);
        return (Double) template.execute((RedisConnection connection) -> connection.incrBy(SafeEncoder.encode(key), num));
    }

    /**
     * set if not exists object to redis, key exist by default time(1h)
     * @param key 键
     * @param value 值
     * @return Integer reply, specifically: 1 if the key was set；0 if the key was not set
     */
    public static Long setnx(final String key, final Object value){
        return setnx(key, value, 60 * 60);
    }

    /**
     * set if not exists object to redis
     * @param key 键
     * @param value 值
     * @param seconds 有效期秒数
     * @return Integer reply, specifically: 1 if the key was set；0 if the key was not set
     */
    public static Long setnx(final String key, final Object value, final Integer seconds){
        return setnx(key, value, seconds, true);
    }

    /**
     * 与上面方法一致，refreshExpireTime为true的时候，每次set会重置key的生存时间，false不会重置
     *
     * @param key
     * @param value
     * @param seconds
     * @param refreshExpireTime
     * @return
     */
    public static Long setnx(final String key, final Object value, final Integer seconds, final Boolean refreshExpireTime) {
        return (Long) template.execute((RedisConnection connection) -> {
            String json = JSON.toJSONString(value);
            byte[] keyBytes = SafeEncoder.encode(key);
            Boolean ret = connection.setNX(keyBytes, SafeEncoder.encode(json));
            if (refreshExpireTime || ret) {
                connection.expire(keyBytes, seconds);
            }
            logger.debug("setnx key={},value={}", key, json);
            return ret ? 1L : 0L;
        });
    }

    /**
     * 原子增加key的值-1
     *
     * @param key 键
     * @return 返回原子-1后的数值
     */
    public static Long decr(final String key) {
        logger.debug("decr key={}", key);
        return (Long) template.execute((RedisConnection connection) -> connection.decr(SafeEncoder.encode(key)));
    }

    /**
     * 原子增加key的值-num
     *
     * @param key 键
     * @param num 原子增加的数量
     * @return 返回原子+num后的数值
     */
    public static Long decrBy(final String key, final long num) {
        logger.debug("decrBy key={},num={}", key, num);
        return (Long) template.execute((RedisConnection connection) -> connection.decrBy(SafeEncoder.encode(key), num));
    }

    /** shiro add method start*/

    /**
     * get value from redis
     *
     * @param key 键
     * @return 返回 value
     */
    public static byte[] get(final byte[] key) {
        return (byte[]) template.execute((RedisConnection connection) -> connection.get(key));
    }

    /**
     * put object to redis,key exist by set time
     *
     * @param key
     * @param value
     */
    public static byte[] set(final byte[] key, final byte[] value, final Integer seconds) {
        template.execute((RedisConnection connection) -> {
            connection.set(key, value);
            connection.expire(key, seconds);
            return value;
        });
        return value;
    }

    /**
     * remove object by key
     *
     * @param key
     * @return
     */
    public static Long del(final byte[] key) {
        return (Long) template.execute((RedisConnection connection) -> connection.del(key));
    }

    /**
     * 查找key
     *
     * @param pattern
     * @return 返回 value
     */
    @SuppressWarnings("unchecked")
    public static Set<byte[]> keys(final String pattern) {
        return (Set<byte[]>) template.execute((RedisConnection connection) -> connection.keys(SafeEncoder.encode(pattern)));
    }

    /**
     * 删除所有元素
     */
    public static void flushDB() {
        logger.debug("flushDB");
        template.execute((RedisConnection connection) -> {
            connection.flushDb();
            return null;
        });
    }

    /**
     * 查询当前KEY数量
     *
     * @return
     */
    public static Long dbSize() {
        return (Long) template.execute(RedisConnection::dbSize);
    }

    /** shiro add method end*/

    @SuppressWarnings("unchecked")
    public static <T> T execute(RedisCallback<T> action){
        return (T) template.execute(action);
    }




}










































