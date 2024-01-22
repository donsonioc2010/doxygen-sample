package com.example.doxygensample.core.api.controller.v1.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @brief 예제요청의 응답 DTO
 * @author jong
 * @date   2024/01/19 16:02
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExampleResponseDto {
	private String result;
}
