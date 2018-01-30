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

    public static ApiResult SUCCESS() {
        ApiResult apiResult = new ApiResult();
        apiResult.setStatus(_SUCCESS);
        return apiResult;
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
}
