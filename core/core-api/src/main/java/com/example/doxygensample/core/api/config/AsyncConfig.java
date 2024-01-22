package com.example.doxygensample.core.api.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @brief 비동기 정보를 설정하는 클래스
 * @details 비동기 처리를 위한 설정을 담당 하는 클래스입니다.
 * @author jong
 * @date   2024/01/19 11:24
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    /**
     * @brief 비동기 처리를 위한 Executor를 반환합니다.
     * @details 비동기 처리를 위한 Executor를 반환합니다.
     * @author jong
     * @date   2024/01/19 11:26
     * @return Executor
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(10000);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(10);
        executor.initialize();
        return executor;
    }

    /**
     * @brief 비동기 처리 중 발생한 Exception을 처리하는 Handler를 반환합니다.
     * @details 비동기 처리 중 발생한 Exception을 처리하는 Handler를 반환합니다. Exception을 처리하는 Handler는 AsyncExceptionHandler를 상속받아 구현합니다.
     * @param @ref AsyncUncaughtExceptionHandler
     * @author jong
     * @date   2024/01/19 11:27
     * @return
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncExceptionHandler();
    }

}
