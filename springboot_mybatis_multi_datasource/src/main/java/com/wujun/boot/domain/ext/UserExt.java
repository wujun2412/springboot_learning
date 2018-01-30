package com.wujun.boot.domain.ext;

import com.wujun.boot.domain.City;
import com.wujun.boot.domain.User;

/**
 * @author wujun
 * @description
 * @date 18/1/30.
 */
public class UserExt extends User {
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
