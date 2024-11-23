package com.thanhdon.product_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    PRODUCT_EXISTED(1001,"product is existed!",HttpStatus.BAD_REQUEST),
    PRODUCT_NOT_EXISTED(1002,"product not existed!", HttpStatus.NOT_FOUND),
    CATEGORY_NOT_EXISTED(1010,"category not existed!!",HttpStatus.NOT_FOUND),
    DUPLICATE_PRODUCTS_COLLECTION(1003,"duplicate id products", HttpStatus.BAD_REQUEST)
    ;

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;

    ErrorCode(int code, String message, HttpStatusCode statusCode ) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}
