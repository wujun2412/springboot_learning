package com.wujun.common.core.exception;

/**
 * @author wujun
 * @description
 * @date 18/2/11.
 */
public class XBusinessException extends XRuntimeException {
    private static final long serialVersionUID = 1469688255681816280L;
    public static final String DEFAULT_FAULT_CODE = "X0001";
    private String xCode;
    private String message;
    private Object result;

    public XBusinessException(String message) {
        this("X0001", message);
    }

    public XBusinessException(String xCode, String message) {
        this(xCode, message, new Throwable());
    }

    public XBusinessException(String xCode, String message, Object result) {
        this(xCode, message, result, new Throwable());
    }

    public XBusinessException(String xCode, String message, Object result, Throwable throwable) {
        this(xCode, message, result, throwable.getMessage(), throwable);
    }

    public XBusinessException(String xCode, String message, String internalMessage) {
        this(xCode, message, (String)internalMessage, (Throwable)null);
    }

    public XBusinessException(String code, String message, Throwable throwable) {
        this(code, message, throwable.getMessage(), throwable);
    }

    public XBusinessException(String xCode, String message, String internalMessage, Throwable throwable) {
        this(xCode, message, (Object)null, internalMessage, throwable);
    }

    public XBusinessException(String xCode, String message, Object result, String internalMessage, Throwable throwable) {
        super("[" + xCode + "] - " + message + internalMessage, throwable);
        this.message = message;
        this.xCode = xCode;
        this.result = result;
    }

    public String getXCode() {
        return this.xCode;
    }

    public void setXCode(String xCode) {
        this.xCode = xCode;
    }

    public String getMessageWithoutCode() {
        return this.message;
    }

    public String getMessage() {
        return "[" + this.xCode + "]" + " - " + this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return this.result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
