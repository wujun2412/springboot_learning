package com.wujun.common.core.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author wujun
 * @description 自定义的Redis键值序列化.
 * 序列化:判断入参Object是否属于JAVA基本数据类型
 * 如果是,则直接转换为string型并getBytes
 * 如果不是,则默认使用JDK自带的序列化方法.
 * @date 18/2/6.
 */
public class RedisKeySerializer implements RedisSerializer<Object> {
    private static final byte[] EMPTY_ARRAY = new byte[0];
    private final Charset charset = UTF_8;
    private static SerializerFeature[] features = {SerializerFeature.DisableCircularReferenceDetect};

    @Override
    public byte[] serialize(Object obj) throws SerializationException {
        if (obj == null) {
            return EMPTY_ARRAY;
        }
        if (obj instanceof String
                || obj instanceof Character
                || obj instanceof Number
                || obj instanceof Boolean) {
            return obj.toString().getBytes();
        }
        String str = JSON.toJSONString(obj, features);
        str = str.replaceAll(":", "-");
        return str.getBytes(charset);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        return null;
    }
}
