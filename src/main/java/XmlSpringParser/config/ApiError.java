package XmlSpringParser.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

// publiczna klasa ApiError
public class ApiError {

    // zdefiniowanie prywatnego finalnego pola obiektu status typu HttpStatus
    private final HttpStatus status;
    // zdefiniowanie prywatnego finalnego pola obiektu errors typu List<String>
    private final List<String> errors;

    // konstruktor z parametrami final status typu HttpStatus, final error typu String
    public ApiError(final HttpStatus status, final String error) {
        // odniesienie do bieżącej instancji klasy
        this.status = status;
        // przypisanie do pola obiektu errors wyniku metody asList o parametrze error wywołanego na klasie Arrays
        errors = Arrays.asList(error);
    }

    // metoda getStatus ma za zadanie zwrócenie status z prywatnego pola obiektu
    public HttpStatus getStatus() {
        return status;
    }

    // metoda get Errors która zwraca Listę Stringów z prywatnego pola obiektu erorrs
    public List<String> getErrors() {
        return errors;
    }
}