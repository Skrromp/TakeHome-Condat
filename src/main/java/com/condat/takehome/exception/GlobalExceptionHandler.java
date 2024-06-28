package com.condat.takehome.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleBadRequestException(MethodArgumentTypeMismatchException ex) {
        String message = ex.getName() + " must be a number!";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}