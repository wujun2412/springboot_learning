package com.wujun.boot.dubbo.validation;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.validation.Validator;
import com.alibaba.dubbo.validation.support.jvalidation.JValidation;

/**
 * @author wujun
 * @description dubbo验证扩展:使抛出XBusinessException异常.
 * @date 18/2/11.
 */
public class DubboValidation extends JValidation {
    public DubboValidation() {
    }

    @Override
    protected Validator createValidator(URL url) {
        return new DubboValidator(url);
    }

}
