package com.wujun.boot.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wujun
 * @description
 * @date 18/2/8.
 */
public class LogHelper {
    private final Logger logger = LoggerFactory.getLogger(LogHelper.class);

    public void logTest(){
        logger.debug("this is a debug message");
        logger.info("this is a info message");
        logger.warn("this is a warn message");
        logger.error("this is a error message");
    }

}
