package com.wujun.common.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @author wujun
 * @description
 * @date 18/2/11.
 */
@Service
public class ExceptionDefinitions {
    private Logger logger = LoggerFactory.getLogger(ExceptionDefinitions.class);
    @Autowired
    private ResourcePatternResolver resourcePatternResolver;
    private Properties exceptionDefinitionProps;

    public ExceptionDefinitions() {
    }

    private Properties getDefinitions() throws IOException {
        if(this.exceptionDefinitionProps == null) {
            Resource[] resources = this.resourcePatternResolver.getResources("classpath*:/props/error.properties");
            this.exceptionDefinitionProps = new Properties();
            Resource[] var2 = resources;
            int var3 = resources.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                Resource resource = var2[var4];
                InputStream stream = resource.getInputStream();

                try {
                    InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);

                    try {
                        this.exceptionDefinitionProps.load(reader);
                    } finally {
                        reader.close();
                    }
                } finally {
                    stream.close();
                }
            }
        }

        return this.exceptionDefinitionProps;
    }

    public String getExceptionMessage(String errorCode) {
        String cannotFoundErrorCodeMessagePattern = "系统错误[ErrorType = ERROR_MESSAGE_DEFINITION, ErrorCode=%s]";
        String message = "";

        try {
            message = (String)this.getDefinitions().get(errorCode);
        } catch (IOException var5) {
            this.logger.error(String.format("Error message for [code=%s] is not defined", new Object[]{errorCode}));
        }

        if(StringUtils.isEmpty(message)) {
            message = String.format("系统错误[ErrorType = ERROR_MESSAGE_DEFINITION, ErrorCode=%s]", new Object[]{errorCode});
        }

        return message;
    }

}
