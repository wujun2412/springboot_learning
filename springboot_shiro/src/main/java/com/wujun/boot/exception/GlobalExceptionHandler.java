package com.wujun.boot.exception;

import com.wujun.common.exceptions.MyLogicExcepion;
import com.wujun.common.responses.ApiResult;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wujun
 * @description
 * @date 19/4/19.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //拦截未授权页面
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(UnauthorizedException.class)
    public ApiResult handleException(UnauthorizedException e) {
        ApiResult result = ApiResult.FAIL(e.getMessage());
        result.setErrCode("403");
        return result;
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(AuthorizationException.class)
    public ApiResult handleException2(AuthorizationException e) {
        ApiResult result = ApiResult.FAIL(e.getMessage());
        result.setErrCode("403");
        return result;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(MyLogicExcepion.class)
    public ApiResult handleMyLogicExcepion(MyLogicExcepion e) {
        ApiResult result = ApiResult.FAIL(e.getMsg());
        result.setErrCode(e.getErrorCode());
        return result;
    }

}
