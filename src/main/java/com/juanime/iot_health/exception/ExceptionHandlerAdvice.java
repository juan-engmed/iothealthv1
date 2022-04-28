package com.juanime.iot_health.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import utils.JsonErrorResponse;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    private static final String CONSTRAINT_VIOLATION = "Violação de restrição";

    @ExceptionHandler(SearchNotFoundException.class)
    public ResponseEntity<String> handleException(SearchNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleException(ConstraintViolationException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleException(IllegalArgumentException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> validationError(MethodArgumentNotValidException exMethod) {

        BindingResult bindingResult = exMethod.getBindingResult();

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        List<String> fieldErrorDtos = fieldErrors.stream()
                .map(f -> f.getField().concat(": ").concat(Objects.requireNonNull(f.getDefaultMessage())))
                .map(String::new)
                .collect(Collectors.toList());

        var responseBody = JsonErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.toString())
                .message(CONSTRAINT_VIOLATION)
                .errorDescription(fieldErrorDtos.toString())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
