package dev.edmond.swapi.web;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.edmond.swapi.error.InvalidObjectException;
import dev.edmond.swapi.error.ObjectNotFoundException;
import lombok.Data;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidObjectException.class)
    public ResponseEntity<GenericExeptionBody> handleInvalidObjectException(
            InvalidObjectException ex) {

        GenericExeptionBody exceptionBody =
                new GenericExeptionBody(ex.getErrorId(), ex.getMessage(), ex.getErrors(), null);
        return ResponseEntity.badRequest().body(exceptionBody);
    }


    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<GenericExeptionBody> handleObjectNotFoundException(
            ObjectNotFoundException ex) {

        GenericExeptionBody exceptionBody = new GenericExeptionBody(ex.getErrorId(),
                ex.getMessage() + ": " + ex.getId(), null, ex.getObjectClass());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionBody);
    }



    @Data
    public static class GenericExeptionBody {
        private final UUID id;
        private final String message;
        private final Map<String, String> errors;
        private final String clazz;

        public GenericExeptionBody(UUID id, String message, Map<String, String> errors,
                String clazz) {
            this.id = id;
            this.message = message;
            this.errors = errors;
            this.clazz = clazz;
        }

    }

}
