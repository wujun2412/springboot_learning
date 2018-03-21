package com.wujun.common.pattern.responsibility;

/**
 * @author wujun
 * @description
 * @date 18/3/21.
 */
public class Request {
    private String type;
    private String content;
    private int num;

    public Request(String type, String content, int num) {
        this.type = type;
        this.content = content;
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
