package com.example.doxygensample.core.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @brief 서버 상태 체크 컨트롤러
 * @details 서버 상태 체크기능 담당 컨트롤러
 * @author jong
 * @date   2024/01/19 15:49
 */
@RestController
public class HealthController {

    /**
     * @brief 서버 상태체크
     * @author jong
     * @date   2024/01/19 15:50
     * @return ResponseEntity<Object>
     */
    @GetMapping("/health")
    public ResponseEntity<Object> health() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
