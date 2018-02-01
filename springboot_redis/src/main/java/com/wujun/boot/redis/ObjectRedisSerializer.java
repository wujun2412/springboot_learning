package com.wujun.boot.redis;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @author wujun
 * @description
 * @date 18/2/1.
 */
public class ObjectRedisSerializer implements RedisSerializer<Object> {
    private Converter<Object, byte[]> serializer = new SerializingConverter();
    private Converter<byte[], Object>deserializer = new DeserializingConverter();

    static final byte[] EMPTY_ARRAY = new byte[0];

    @Override
    public byte[] serialize(Object o){
        if (o == null){
            return EMPTY_ARRAY;
        }
        try {
            return  serializer.convert(o);
        } catch (SerializationException e){
            return EMPTY_ARRAY;
        }
    }

    @Override
    public Object deserialize(byte[] bytes) {
        if (isEmpty(bytes)){
            return null;
        }
        try {
            return deserializer.convert(bytes);
        } catch (SerializationException e){
            throw new SerializationException("Cannot deserialize",e);
        }
    }

    private boolean isEmpty(byte[] bytes){
        return (bytes==null||bytes.length==0);
    }
}
