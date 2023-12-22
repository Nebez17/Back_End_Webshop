package com.example.demo.Exeptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends IHttpException {
    private static final HttpStatus statusCode = HttpStatus.BAD_REQUEST;
    public BadRequestException(String message) {
        super(statusCode, message);
    }
}