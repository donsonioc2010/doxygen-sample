package com.example.doxygensample.core.api.config;

import com.example.doxygensample.core.api.support.error.CoreApiException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * @brief AsyncExceptionHandler
 * @details AsyncExceptionHandler하기 위한 클래스 입니다.
 * @author jong
 * @date   2024/01/19 11:27
 */
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * @brief Exception 처리
     * @details Exception 처리를 위한 메소드 입니다.
     * @author jong
     * @date   2024/01/19 11:28
     * @param e
     * @param method
     * @param params
     */
    @Override
    public void handleUncaughtException(Throwable e, Method method, Object... params) {
        if (e instanceof CoreApiException) {
            switch (((CoreApiException) e).getErrorType().getLogLevel()) {
                case ERROR -> log.error("CoreApiException : {}", e.getMessage(), e);
                case WARN -> log.warn("CoreApiException : {}", e.getMessage(), e);
                default -> log.info("CoreApiException : {}", e.getMessage(), e);
            }
        }
        else {
            log.error("Exception : {}", e.getMessage(), e);
        }
    }

}
