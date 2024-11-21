package com.thanhdon.product_service.exception;

import com.thanhdon.product_service.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler{


    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException exception){
        ErrorCode errorCode = exception.getErrorCode();

        return ResponseEntity.status(errorCode.getStatusCode())
                .body(ApiResponse.builder()
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .build());
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    ResponseEntity<ApiResponse> handlingDuplicateProductId(SQLIntegrityConstraintViolationException exception){

        ErrorCode error = ErrorCode.DUPLICATE_PRODUCTS_COLLECTION;

        return ResponseEntity.status(error.getStatusCode())
                .body(ApiResponse.builder()
                        .message(error.getMessage())
                        .build());
    }
}
