package com.wujun.boot.config.dbconfig;

import com.alibaba.druid.util.DruidPasswordCallback;
import com.wujun.boot.util.Constants;
import com.wujun.common.utils.AESUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Properties;

/**
 * @author wujun
 * @description 数据库密码回调解密
 * @date 18/1/23.
 */
public class DBPasswordCallback extends DruidPasswordCallback {
    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        String pwd = properties.getProperty("password");
        System.out.println("数据库密码回调解密，解密前的密码："+pwd+".............");
        if (StringUtils.isNotBlank(pwd)){
            try {
                /**
                 * 将application.yml配置得到的密码进行解密
                 */
                String password = AESUtils.decrypt(pwd, Constants._AES_KEY);
                setPassword(password.toCharArray());
                System.out.println("数据库密码回调解密，解密后的密码："+password+".............");
            } catch (Exception e){
                setPassword(pwd.toCharArray());
            }
        }
    }
}
