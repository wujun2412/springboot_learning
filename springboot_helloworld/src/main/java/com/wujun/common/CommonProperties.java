package com.wujun.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wujun
 * @description
 * @date 18/1/9.
 */
@Component
public class CommonProperties {

    @Value("${com.wujun.blog.name}")
    private String name;

    @Value("${com.wujun.blog.title}")
    private String title;

    @Value("${com.wujun.blog.desc}")
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
