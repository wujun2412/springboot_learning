package com.wujun.boot.dubbo.validation;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.validation.support.jvalidation.JValidator;
import com.wujun.common.core.exception.XExceptionFactory;
import com.wujun.common.utils.RegexUtils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @author wujun
 * @description  dubbo验证扩展:使抛出XBusinessException异常.
 * @date 18/2/11.
 */
public class DubboValidator extends JValidator {
    public DubboValidator(URL url) {
        super(url);
    }

    @Override
    public void validate(String methodName, Class<?>[] parameterTypes, Object[] arguments) throws Exception {
        try {
            super.validate(methodName, parameterTypes, arguments);
        } catch (Exception e) {
            if (e instanceof ConstraintViolationException) {
                Set<ConstraintViolation<?>> violations = ((ConstraintViolationException) e).getConstraintViolations();
                String validationMsg = "";
                for (ConstraintViolation c : violations) {
                    validationMsg = c.getMessage();
                }
                if (RegexUtils.isErrorCode(validationMsg)) {
                    throw XExceptionFactory.create(validationMsg);
                }
                throw XExceptionFactory.create("W_ERROR_COMMON_1003", validationMsg);
            }
            throw XExceptionFactory.create("W_ERROR_COMMON_1003", e.getMessage());
        }
    }

}
