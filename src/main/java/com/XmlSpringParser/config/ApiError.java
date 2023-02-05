package com.XmlSpringParser.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {

    private final HttpStatus status;
    private final List<String> errors;

    public ApiError(final HttpStatus status, final String error) {
        this.status = status;
        errors = Arrays.asList(error);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public List<String> getErrors() {
        return errors;
    }

}