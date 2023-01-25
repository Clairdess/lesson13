package com.vkatit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> exceptionSize(EmptyResultDataAccessException exception) {
        log.error(exception.getMessage(), exception);
        return ResponseEntity.badRequest().body("Incorrect id");
    }
}
