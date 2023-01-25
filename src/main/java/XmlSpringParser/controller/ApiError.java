package XmlSpringParser.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {

    private HttpStatus status;
    private List<String> errors;

    public ApiError() {
        super();
    }

    public ApiError(final HttpStatus status, final List<String> errors) {
        super();
        this.status = status;
        this.errors = errors;
    }

    public ApiError(final HttpStatus status, final String error) {
        super();
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