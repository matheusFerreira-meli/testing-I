package com.meli.obterdiploma.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        List<FieldError> errors = ex.getBindingResult().getFieldErrors();

        System.out.println(ex.getMessage());
        System.out.println(ex.getFieldError());

        return new ResponseEntity<>(ExceptionDetails.builder()
                .title("Parâmetros inválidos")
                .message("Os campos estão inválidos")
                .fields(errors.stream()
                        .map(FieldError::getField)
                        .collect(Collectors.joining(", ")))
                .fieldsMessage(errors.stream()
                        .map(FieldError::getDefaultMessage)
                        .collect(Collectors.joining(", ")))
                .timestamps(LocalDateTime.now())
                .build(), status);
    }
}
