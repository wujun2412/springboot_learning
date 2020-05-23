package com.wujun.boot.domain;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author: Jun.Wu
 * @Date: 2020/5/23 16:09
 * @Description:
 */
public class MqMessage implements Serializable {
    /**
     * 定时过期时间(单位:秒)，马上消费设置:0
     */
    private int delaySec;

    /**
     * 回调地址
     */
    private String callBackUrl;

    /**
     * 消息参数
     */
    private Map<String, Object> params;

    private String createTime;

    private String messageId;

    public MqMessage() {
    }

    public int getDelaySec() {
        return delaySec;
    }

    public void setDelaySec(int delaySec) {
        this.delaySec = delaySec;
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "MqMessage{" +
                "delaySec=" + delaySec +
                ", callBackUrl='" + callBackUrl + '\'' +
                ", params=" + params +
                ", createTime='" + createTime + '\'' +
                ", messageId='" + messageId + '\'' +
                '}';
    }
}
