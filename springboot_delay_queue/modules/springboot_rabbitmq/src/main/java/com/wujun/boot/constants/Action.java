package com.wujun.boot.constants;

/**
 * @Author: Jun.Wu
 * @Date: 2020/5/23 16:41
 * @Description:
 */
public enum Action {
    /**
     * 处理成功
     */
    ACCEPT,
    /**
     * 可以重试的错误
     */
    RETRY,
    /**
     * 无需重试的错误
     */
    REJECT;
}
