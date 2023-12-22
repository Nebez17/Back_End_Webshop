package com.example.demo.Exeptions.ExpectionHandeler;

import com.example.demo.Exeptions.IHttpException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IHttpException.class)
    public ResponseEntity<String> handleHttpException(IHttpException httpException) {

        return ResponseEntity.status(httpException.getStatusCode()).body(httpException.getMessage());
    }
}
