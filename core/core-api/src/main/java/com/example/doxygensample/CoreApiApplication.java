package com.example.doxygensample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * @brief  CoreApiApplication
 * @details Spring Boot Application의 시작 클래스
 * @author jong
 * @date   2024/01/19 11:21
 */
@ConfigurationPropertiesScan
@SpringBootApplication
public class CoreApiApplication {

    /**
     *
     * @brief Main실행 메소드
     * @details 실행시 Spring Boot Application을 실행한다.
     * @author jong
     * @date   2024/01/19 11:22
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(CoreApiApplication.class, args);
    }

}
