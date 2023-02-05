package com.XmlSpringParser.controller;

import com.XmlSpringParser.config.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll() {
        final var apiError = new ApiError(
                HttpStatus.BAD_REQUEST, "Could not upload the file! You need to parse XML File.");

        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

}
