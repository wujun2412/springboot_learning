package com.wujun.common.core.util;

/**
 * @author wujun
 * @description
 * @date 18/2/7.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对象操作工具类
 *
 * @author Guoqw
 * @since 2015-07-09 18:34
 */
public class SerializeUtils {

    private static Logger logger = LoggerFactory.getLogger(SerializeUtils.class);

    /**
     * 序列化对象
     */
    public static byte[] serialize(Object object) {
        Assert.notNull(object,"object can not be null!");
        if(!(object instanceof Serializable)) {
            throw new IllegalArgumentException("requires a Serializable payload " + "but received an object of type [" + object.getClass().getName() + "]");
        }
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            oos.flush();
            return baos.toByteArray();
        } catch (Exception e) {
            logger.error("serialize fail",e);
        }
        return null;
    }

    /**
     * 反序列化对象
     */
    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            if (bytes != null && bytes.length > 0){
                bais = new ByteArrayInputStream(bytes);
                ObjectInputStream ois = new ObjectInputStream(bais);
                return ois.readObject();
            }
        } catch (Exception e) {
            logger.error("unserialize fail",e);
        }
        return null;
    }
}

