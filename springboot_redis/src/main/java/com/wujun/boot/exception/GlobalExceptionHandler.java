package com.wujun.boot.exception;

import com.wujun.common.core.exception.XBusinessException;
import com.wujun.common.responses.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author maweijun
 * @description
 * @create 17/7/11
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 拦截所有Exception类型的异常，统一处理返回信息
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApiResult handler(Exception ex) {
        ApiResult result = ApiResult.FAIL();

        if (ex instanceof XBusinessException) {
            XBusinessException seckillException = (XBusinessException) ex;
            result.setMsg(seckillException.getMessage());
            result.setErrCode(seckillException.getXCode());
            LOGGER.error("发生异常。", ex);
        } else {
            result.setMsg("出现错误，请联系管理员。");
            LOGGER.error("出现错误，请联系管理员。", ex);
        }
        return result;
    }
}
