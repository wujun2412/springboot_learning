package com.wujun.boot.controller;

import com.wujun.boot.log.LogHelper;
import com.wujun.common.responses.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujun
 * @description
 * @date 18/2/8.
 */
@RestController
@RequestMapping("/log")
public class LogController {
    private final Logger logger = LoggerFactory.getLogger(LogController.class);


    @RequestMapping("/writelog")
    public ApiResult writeLog(){
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        new LogHelper().logTest();
        return ApiResult.SUCCESS();
    }


}
