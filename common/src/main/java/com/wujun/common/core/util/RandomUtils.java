package com.wujun.common.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Random;

/**
 * <p>Title: RandomUtils</p>
 * <p>Date: 17/5/4 </p>
 * <p>Description: </p>
 *
 * @author sunxinhe
 */
public class RandomUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(RandomUtils.class);


    public static String randomString(Integer length) {
        char[] chars = new char[]{
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z',
                '-'};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = new Random().nextInt(chars.length);
            result.append(chars[index]);
        }
        return result.toString();
    }

    public static Integer randomInt(Integer length) {
        int min = BigInteger.TEN.pow(length - 1).intValue();
        int max = BigInteger.valueOf(min).multiply(BigInteger.TEN).subtract(BigInteger.ONE).intValue();

        Random random = new Random();
        return random.nextInt(max) % min + min;
    }

    public static String randomMobilePhone() {
        return "135" + randomInt(8);
    }

    public static String randomJianHan(Integer length) {
        String ret = "";
        for (int i = 0; i < length; i++) {
            String str = null;
            int hightPos, lowPos; // 定义高低位
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39))); //获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); //获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try {
                str = new String(b, "GBK"); //转成中文
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            ret += str;
        }
        return ret;
    }

}
