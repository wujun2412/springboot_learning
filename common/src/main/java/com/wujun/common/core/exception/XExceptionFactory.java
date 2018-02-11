package com.wujun.common.core.exception;

import com.wujun.common.core.context.ApplicationContextStaticProvider;

/**
 * @author wujun
 * @description
 * @date 18/2/11.
 */
public class XExceptionFactory {
    private static ExceptionDefinitions exceptionDefinitions;

    public XExceptionFactory() {
    }

    public static XBusinessException create(String errorCode, String... args) {
        return createWithResult(errorCode, (Object)null, args);
    }

    public static XBusinessException createWithResult(String errorCode, Object result, String... args) {
        String exceptionPattern = getExceptionDefinitions().getExceptionMessage(errorCode);
        if(args.length > 0) {
            String errorMsg = String.format(exceptionPattern, args);
            return new XBusinessException(errorCode, errorMsg, result);
        } else {
            return new XBusinessException(errorCode, exceptionPattern, result);
        }
    }

    private static ExceptionDefinitions getExceptionDefinitions() {
        if(exceptionDefinitions == null) {
            exceptionDefinitions = (ExceptionDefinitions) ApplicationContextStaticProvider.getApplicationContext().getBean(ExceptionDefinitions.class);
        }

        return exceptionDefinitions;
    }
}
