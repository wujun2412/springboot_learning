package com.wujun.common.responses;

/**
 *
 */
public class ApiResult<T> {
    private static final String _SUCCESS = "success";
    private static final String _FAIL = "fail";

    private String status;

    private String errCode;

    private String msg;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ApiResult() {
    }

    public ApiResult(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public ApiResult(String status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ApiResult(String status, String errCode, String msg, T data) {
        this.status = status;
        this.errCode = errCode;
        this.msg = msg;
        this.data = data;
    }

    public static ApiResult SUCCESS() {
        ApiResult apiResult = new ApiResult();
        apiResult.setStatus(_SUCCESS);
        return apiResult;
    }

    public static ApiResult SUCCESS(String msg) {
        ApiResult apiResult = new ApiResult();
        apiResult.setStatus(_SUCCESS);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult(_SUCCESS, data);
    }

    public static ApiResult FAIL() {
        ApiResult apiResult = new ApiResult();
        apiResult.setStatus(_FAIL);
        return apiResult;
    }

    public static ApiResult FAIL(String msg){
        ApiResult apiResult = new ApiResult();
        apiResult.setStatus(_FAIL);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public static <T> ApiResult<T> FAIL(String msg, T data){
        ApiResult apiResult = new ApiResult(_FAIL, msg, data);
        return apiResult;
    }
}
