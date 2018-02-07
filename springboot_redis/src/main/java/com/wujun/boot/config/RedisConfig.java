package com.wujun.boot.config;

import com.wujun.common.core.redis.RedisKeySerializer;
import com.wujun.common.core.redis.RedisValueSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author wujun
 * @description
 * @date 18/2/1.
 */
@Configuration
public class RedisConfig {
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

//    @Bean("objectRedisTemplate")
//    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
//        RedisTemplate<String,Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(jedisConnectionFactory);
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new ObjectRedisSerializer());
//        return template;
//    }

    @Bean("redisTemplate")
    public RedisTemplate redisTemplate(){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        redisTemplate.setKeySerializer(new RedisKeySerializer());
        redisTemplate.setValueSerializer(new RedisValueSerializer());
        return redisTemplate;
    }

}
