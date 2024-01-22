package com.example.doxygensample.test.api;

import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;
import org.springframework.restdocs.operation.preprocess.Preprocessors;

/**
 * @brief RestDocs에 사용되는 유틸리티 클래스
 * @author jong
 * @date   2024/01/19 16:06
 */
public class RestDocsUtils {

    /**
     * @brief RestDocs에 표시되는 호스트명을 설정합니다.
     * @details Method의 세부 정보
     * @author jong
     * @date   2024/01/19 16:07
     * @todo 호스트명 바꿔야 하는 TODO샘플 기록입니다. [링크 샘플](https://www.naver.com)
     * @bug 버그입니다 고치세요 [링크 샘플](https://www.naver.com)
     * @see 그냥 이것저것 보여줘야하는 것, [링크 샘플](https://www.naver.com)
     * @return OperationRequestPreprocessor
     */
    public static OperationRequestPreprocessor requestPreprocessor() {

        return Preprocessors.preprocessRequest(
                Preprocessors.modifyUris().scheme("http").host("kspo.was").removePort(),
                Preprocessors.prettyPrint());
    }

    public static OperationResponsePreprocessor responsePreprocessor() {
        return Preprocessors.preprocessResponse(Preprocessors.prettyPrint());
    }

}
