package com.example.demo.Exeptions;

import org.springframework.http.HttpStatus;

public class IHttpException extends RuntimeException {

    private final HttpStatus statusCode;

    public IHttpException(HttpStatus statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}