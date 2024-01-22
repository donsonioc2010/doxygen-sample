package com.example.doxygensample.core.api.domain;

import org.springframework.stereotype.Service;

/**
 *
 * @brief 예제 서비스
 * @author jong
 * @date   2024/01/19 15:47
 */
@Service
public class ExampleService {

    /**
     *
     * @brief 예제 비즈니스 처리 메소드
     * @details 샘플용 호출 메소드입니다.
     * @author jong
     * @date   2024/01/19 15:46
     * @param exampleData
     * @return ExampleResult
     */
    public ExampleResult processExample(ExampleData exampleData) {
        return new ExampleResult(exampleData.getValue());
    }

}
