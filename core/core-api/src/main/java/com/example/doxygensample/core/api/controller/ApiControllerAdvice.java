package com.example.doxygensample.core.api.controller;

import com.example.doxygensample.core.api.support.error.CoreApiException;
import com.example.doxygensample.core.api.support.error.ErrorType;
import com.example.doxygensample.core.api.support.response.ApiResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @brief 예외처리를 하는 Controller Advice
 * @author jong
 * @date   2024/01/19 16:03
 */
@RestControllerAdvice
public class ApiControllerAdvice {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * @brief CoreApiException을 처리하는 Handler
     * @details Log로 이력을 남긴 이후, 오류를 반환합니다.
     * @author jong
     * @date   2024/01/19 16:03
     * @param e CoreApiException
     * @return ResponseEntity<ApiResponse<?>>
     */
    @ExceptionHandler(CoreApiException.class)
    public ResponseEntity<ApiResponse<?>> handleCoreApiException(CoreApiException e) {
        switch (e.getErrorType().getLogLevel()) {
            case ERROR -> log.error("CoreApiException : {}", e.getMessage(), e);
            case WARN -> log.warn("CoreApiException : {}", e.getMessage(), e);
            default -> log.info("CoreApiException : {}", e.getMessage(), e);
        }
        return new ResponseEntity<>(ApiResponse.error(e.getErrorType(), e.getData()), e.getErrorType().getStatus());
    }

    /**
     * @brief Exception을 처리하는 Handler
     * @details 정의되지 않는 모든 Exception을 처리합니다.
     * @author jong
     * @date   2024/01/19 16:05
     * @param e
     * @return ResponseEntity<ApiResponse<?>>
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception e) {
        log.error("Exception : {}", e.getMessage(), e);
        return new ResponseEntity<>(ApiResponse.error(ErrorType.DEFAULT_ERROR), ErrorType.DEFAULT_ERROR.getStatus());
    }

}
