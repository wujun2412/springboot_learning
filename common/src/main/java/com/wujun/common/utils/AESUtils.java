package com.wujun.common.utils;

import com.wujun.common.exceptions.MyLogicExcepion;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * @author wujun
 * @description AES加密工具
 * @date 18/1/23.
 */
public class AESUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(AESUtils.class);

    /**
     * 解密字节数组
     *
     * @param cipheredBytes 密文字节数组
     * @param key           密钥字节数组
     * @param initialVector 初始向量
     * @return 明文字节数组
     */
    public static byte[] decrypt(byte[] cipheredBytes, byte[] key, byte[] initialVector) {
        byte[] plainBytes = null;
        SecretKeySpec secretKeySpecy = new SecretKeySpec(key, Constants._AES_ENCRYPTION_ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(Constants._AES_CBC_PKCS5_PADDING);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpecy, ivParameterSpec);
            plainBytes = cipher.doFinal(cipheredBytes);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("算法不存在（NoSuchAlgorithmException）！", e);
            throw new MyLogicExcepion("解密Byte数组出现异常，算法不存在。", "NoSuchAlgorithm");
        } catch (NoSuchPaddingException e) {
            LOGGER.error("补位算法不存在（NoSuchPaddingException）！", e);
            throw new MyLogicExcepion("解密Byte数组出现异常，补位算法不存在。", "NoSuchPadding");
        } catch (IllegalBlockSizeException e) {
            LOGGER.error("非法的块大小（IllegalBlockSizeException）！", e);
            throw new MyLogicExcepion("解密Byte数组出现异常，非法的块大小。", "IllegalBlockSize");
        } catch (BadPaddingException e) {
            LOGGER.error("补位错误（BadPaddingException）！", e);
            throw new MyLogicExcepion("解密Byte数组出现异常，补位错误。", "BadPadding");
        } catch (InvalidAlgorithmParameterException e) {
            LOGGER.error("错误的算法参数（InvalidAlgorithmParameterException）！", e);
            throw new MyLogicExcepion("解密Byte数组出现异常，错误的算法参数。", "InvalidAlgorithmParameter");
        } catch (InvalidKeyException e) {
            LOGGER.error("错误的密钥（InvalidKeyException）！", e);
            throw new MyLogicExcepion("解密Byte数组出现异常，错误的密钥。", "InvalidKey");
        }
        return plainBytes;
    }

    /**
     * 加密字节数组
     *
     * @param plainBytes    明文字节数组
     * @param key           密钥字节数组
     * @param initialVector 初始向量
     * @return 密文字节数组
     */
    public static byte[] encrypt(byte[] plainBytes, byte[] key, byte[] initialVector) {
        byte[] cipheredBytes = null;
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, Constants._AES_ENCRYPTION_ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
        try {
            Cipher cipher = Cipher.getInstance(Constants._AES_CBC_PKCS5_PADDING);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            cipheredBytes = cipher.doFinal(plainBytes);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("算法不存在（NoSuchAlgorithmException）！", e);
            throw new MyLogicExcepion("加密Byte数组出现异常，算法不存在。", "NoSuchAlgorithm");
        } catch (NoSuchPaddingException e) {
            LOGGER.error("补位算法不存在（NoSuchPaddingException）！", e);
            throw new MyLogicExcepion("加密Byte数组出现异常，补位算法不存在。", "NoSuchPadding");
        } catch (IllegalBlockSizeException e) {
            LOGGER.error("非法的块大小（IllegalBlockSizeException）！", e);
            throw new MyLogicExcepion("加密Byte数组出现异常，非法的块大小。", "IllegalBlockSize");
        } catch (BadPaddingException e) {
            LOGGER.error("补位错误（BadPaddingException）！", e);
            throw new MyLogicExcepion("加密Byte数组出现异常，补位错误。", "BadPadding");
        } catch (InvalidAlgorithmParameterException e) {
            LOGGER.error("错误的算法参数（InvalidAlgorithmParameterException）！", e);
            throw new MyLogicExcepion("加密Byte数组出现异常，错误的算法参数。", "InvalidAlgorithmParameter");
        } catch (InvalidKeyException e) {
            LOGGER.error("错误的密钥（InvalidKeyException）！", e);
            throw new MyLogicExcepion("加密Byte数组出现异常，错误的密钥。", "InvalidKey");
        }
        return cipheredBytes;
    }

    /**
     * 获取密钥的字节数组
     *
     * @param key 密钥
     * @return 密钥字节数组
     */
    private static byte[] getKeyBytes(String key) {
        byte[] keyBytes = new byte[16];
        byte[] parameterKeyBytes = new byte[0];
        try {
            parameterKeyBytes = key.getBytes(Constants._DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("不支持的字符集（UnsupportedEncodingException）！", e);
            throw new MyLogicExcepion("获取密钥字节数组出现异常，不支持的字符集。", "UnsupportedEncoding");
        }
        System.arraycopy(parameterKeyBytes, 0, keyBytes, 0, Math.min(parameterKeyBytes.length, keyBytes.length));
        return keyBytes;
    }

    /**
     * 加密字符串
     *
     * @param plainText 明文
     * @param key       密钥
     * @return 密文
     */
    public static String encrypt(String plainText, String key) {
        byte[] plainBytes = new byte[0];
        try {
            plainBytes = plainText.getBytes(Constants._DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("不支持的字符集（UnsupportedEncodingException）！", e);
            throw new MyLogicExcepion("加密字符串出现异常，不支持的字符集。", "UnsupportedEncoding");
        }
        byte[] keyBytes = getKeyBytes(key);
        return Base64.encodeBase64String(encrypt(plainBytes, keyBytes, Constants._AES_CBC_INITIAL_VECTOR.getBytes()));
    }

    /**
     * 解密字符串
     *
     * @param encryptedText 密文
     * @param key           密钥
     * @return 明文
     */
    public static String decrypt(String encryptedText, String key) {
        String plainText = null;
        byte[] cipheredBytes = Base64.decodeBase64(encryptedText);
        byte[] keyBytes = getKeyBytes(key);
        try {
            plainText = new String(decrypt(cipheredBytes, keyBytes,  Constants._AES_CBC_INITIAL_VECTOR.getBytes()), Constants._DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("不支持的字符集（UnsupportedEncodingException）！", e);
            throw new MyLogicExcepion("解密字符串出现异常，不支持的字符集。", "UnsupportedEncoding");
        }
        return plainText;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        /*
         * 加密
         */
        System.out.println("使用AES对称加密，请输入加密的规则");
        String encodeRules=scanner.next();
        System.out.println("请输入要加密的内容:");
        String content = scanner.next();
        System.out.println("根据输入的规则"+encodeRules+"加密后的密文是:"+encrypt(content,encodeRules));

        /*
         * 解密
         */
        System.out.println("使用AES对称解密，请输入加密的规则：(须与加密相同)");
        encodeRules=scanner.next();
        System.out.println("请输入要解密的内容（密文）:");
        content = scanner.next();
        System.out.println("根据输入的规则"+encodeRules+"解密后的明文是:"+decrypt(content,encodeRules));

//        String str = "123456";
//        System.out.println("Aes decrypt: " + encrypt(str, "T8D4AK1BESOVH2Y0"));
//        System.out.println("de"+decrypt("cQauMIWNJ/78m7x+ZAENMA==","T8D4AK1BESOVH2Y0"));
//        try {
//            System.out.println("apache codec encode: " + Base64.encodeBase64String(str.getBytes(Constants._DEFAULT_ENCODING)));
//            System.out.println("jdk encode: " + Base64Utils.encode(str.getBytes()));
//            System.out.println("apache codec encode, jdk decode: " +
//                    Base64Utils.decode(new String(Base64.encodeBase64String(str.getBytes(Constants._DEFAULT_ENCODING))).getBytes()));
//            //    System.out.println(Base64Util.decode(new String(Base64Util.encode(str))));
//        } catch (UnsupportedEncodingException e) {
//            LOGGER.error(e.getMessage());
//        }
//
//        System.out.println("end");
    }



}
