package com.wujun.boot.service;

import com.wujun.boot.domain.ext.UserExt;

/**
 * @author wujun
 * @description
 * @date 18/1/30.
 */
public interface UserService {

    UserExt findByName(String userName);
}
