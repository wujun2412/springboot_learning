package com.wujun.boot.domain;

import java.io.Serializable;

/**
 * @author wujun
 * @description
 * @date 19/4/23.
 */
public class SysUser implements Serializable {
    private static final long serialVersionUID = 131874653158121199L;

    private Long id;

    private String userName;

    private String password;

    /**
     * 是否启用
     */
    private Integer userEnable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserEnable() {
        return userEnable;
    }

    public void setUserEnable(Integer userEnable) {
        this.userEnable = userEnable;
    }
}
