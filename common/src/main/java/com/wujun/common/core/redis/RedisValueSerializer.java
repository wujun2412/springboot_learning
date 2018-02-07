package com.wujun.common.core.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @author wujun
 * @description 自定义的Redis值序列化.
 * @date 18/2/6.
 */
public class RedisValueSerializer implements RedisSerializer<Object> {
    private static final byte[] EMPTY_ARRAY = new byte[0];
    private static SerializerFeature[] features = {SerializerFeature.WriteClassName};

    static {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }

    @Override
    public byte[] serialize(Object obj) throws SerializationException {
        if (obj == null) {
            return EMPTY_ARRAY;
        }
        try {
            return JSON.toJSONBytes(obj, features);
        } catch (Exception e) {
            throw new SerializationException("Count not write JSON: " + e.getMessage(), e);
        }

    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (isEmpty(bytes)) {
            return null;
        }

        try {
            return JSON.parseObject(bytes, Object.class);
        } catch (Exception e) {
            throw new SerializationException("Could not read JSON: " + e.getMessage(), e);
        }
    }

    private boolean isEmpty(byte[] bytes) {
        return (bytes == null || bytes.length == 0);
    }
}
