package com.wujun.boot.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Jun.Wu
 * @Date: 2020/11/25 10:23
 * @Description:
 */
@Data
public class Message {
    private Long id;    //id
    private String msg; //消息
    private Date sendTime;  //时间戳
}
