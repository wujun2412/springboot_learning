package com.wujun.common.exceptions;

/**
 * @author wujun
 * @description
 * @date 18/1/23.
 */
public class MyLogicExcepion extends RuntimeException {

    public static final String ERROR_CODE_PREFIX_WUJUN_DEFAULT = "ERR_DMS_DEFAULT_";
    public static final String ERROR_CODE_PREFIX_WUJUN_APPCENTER = "ERR_DMS_APPCENTER_";
    public static final String ERROR_CODE_PREFIX_WUJUN_NOTIFY = "ERR_DMS_NOTIFY_";
    public static final String ERROR_CODE_PREFIX_WUJUN_ANALYZE = "ERR_DMS_ANALYZE_";

    /**
     *   错误消息
     */
    private String msg;
    /**
     * 异常码
     */
    private String errorCode;
    private Throwable throwable;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorCode() {
        return getErrorCodePrifix() + errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public String getErrorCodePrifix() {
        return ERROR_CODE_PREFIX_WUJUN_DEFAULT;
    }


    public MyLogicExcepion() {
        super();
    }

    public MyLogicExcepion(String msg) {
        super(msg);
        this.msg = msg;

    }

    public MyLogicExcepion(String msg, Throwable throwable) {
        super(msg, throwable);
        this.msg = msg;
        this.throwable = throwable;
    }

    public MyLogicExcepion(String msg, String errorCode) {
        this(msg, null, errorCode);
    }

    public MyLogicExcepion(String msg, Throwable throwable, String errorCode) {
        super(msg);
        this.msg = msg;
        this.throwable = throwable;
        this.errorCode = errorCode;
    }

}
