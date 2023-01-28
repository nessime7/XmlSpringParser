package XmlSpringParser.controller;

import XmlSpringParser.config.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// adnotacja @ControllerAdvice, służy do tworzenia globalnej obsługi wyjątków dla wszystkich kontrolerów w aplikacji Springa
@ControllerAdvice
public class GlobalExceptionController {

    // adnotacja Springa używana do zdefiniowania metody,
    // która będzie obsługiwać wyjątki zgłaszane przez inne metody w tym samym kontrolerze
    @ExceptionHandler({Exception.class})
    // publiczna metoda handleAll typu ResponseEntity<Object>
    public ResponseEntity<Object> handleAll() {
       // zdefiniowanie zmiennej apiError typu ApiError z parametrami pola BAD_REQUEST
        // na referencji klasy HttpStatus i Stringiem
        final var apiError = new ApiError(
                HttpStatus.BAD_REQUEST, "Could not upload the file! You need to parse XML File.");
        // zwrócenie nowej klasy ResponseEntity z parametrami zmiennej apiError, nowej klasy HttpHeaders,
        // oraz wyniku getStatus wywołanej na zmiennej apiError
        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }
}
