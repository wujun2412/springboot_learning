package com.wujun.common.core.exception;

/**
 * @author wujun
 * @description
 * @date 18/2/11.
 */
public class XRuntimeException extends RuntimeException {
    public XRuntimeException() {
    }

    public XRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
