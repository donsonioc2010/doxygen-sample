package com.example.doxygensample.core.api.controller.v1.request;

import com.example.doxygensample.core.api.domain.ExampleData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @brief 예제 요청을 받는 DTO
 * @author jong
 * @date   2024/01/19 16:01
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExampleRequestDto {
    private String data;
    public ExampleData toExampleData() {
        return new ExampleData(data, data);
    }
}
