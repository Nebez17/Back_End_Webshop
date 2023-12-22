package com.example.demo.Exeptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends IHttpException {
    private static final HttpStatus statusCode = HttpStatus.NOT_FOUND;

    public NotFoundException(String message) {
        super(statusCode, message);
    }
}