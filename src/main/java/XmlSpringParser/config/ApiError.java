package XmlSpringParser.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

// klasa pomocna przy obsłudze błędów
public class ApiError {

    private final HttpStatus status;
    private final List<String> errors;

    // konstruktor metody
    public ApiError(final HttpStatus status, final String error) {
        this.status = status;
        errors = Arrays.asList(error);
    }

    // metoda która ma nam zwrócić HttpStatus
    public HttpStatus getStatus() {
        return status;
    }

    // metoda która ma zwrócić nam Stringa z wiadomością o błędzie
    public List<String> getErrors() {
        return errors;
    }
}