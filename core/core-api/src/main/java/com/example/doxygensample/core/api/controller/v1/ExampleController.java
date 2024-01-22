package com.example.doxygensample.core.api.controller.v1;

import com.example.doxygensample.core.api.controller.v1.request.ExampleRequestDto;
import com.example.doxygensample.core.api.controller.v1.response.ExampleResponseDto;
import com.example.doxygensample.core.api.domain.ExampleData;
import com.example.doxygensample.core.api.domain.ExampleResult;
import com.example.doxygensample.core.api.domain.ExampleService;
import com.example.doxygensample.core.api.support.response.ApiResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @brief Sample Controller
 * @details Sample Controller의 세부 정보
 * @author jong
 * @date   2024/01/19 15:48
 */
@RestController
public class ExampleController {

    private final ExampleService exampleExampleService;

    public ExampleController(ExampleService exampleExampleService) {
        this.exampleExampleService = exampleExampleService;
    }

    /**
     *
     * @brief 예제 Get요청
     * @details 예제 세부 요청
     * @author jong
     * @date   2024/01/19 15:36
     * @param String exampleValue 예제 값
     * @param String exampleParam 예제 파라미터
     * @return ApiResponse<ExampleResponseDto>
     */
    @GetMapping("/get/{exampleValue}")
    public ApiResponse<ExampleResponseDto> exampleGet(@PathVariable String exampleValue,
            @RequestParam String exampleParam) {
        ExampleResult result = exampleExampleService.processExample(new ExampleData(exampleValue, exampleParam));
        return ApiResponse.success(new ExampleResponseDto(result.getData()));
    }

    /**
     *
     * @brief Method의 간단한 정보
     * @details Method의 세부 정보
     * @author jong
     * @date   2024/01/19 15:44
     * @param ExampleRequestDto request
     * @return ApiResponse<ExampleResponseDto>
     */
    @PostMapping("/post")
    public ApiResponse<ExampleResponseDto> examplePost(@RequestBody ExampleRequestDto request) {
        ExampleResult result = exampleExampleService.processExample(request.toExampleData());
        return ApiResponse.success(new ExampleResponseDto(result.getData()));
    }

}
