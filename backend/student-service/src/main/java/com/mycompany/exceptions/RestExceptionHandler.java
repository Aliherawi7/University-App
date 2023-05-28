package com.mycompany.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest) {
        String errorDetails = resourceNotFoundException.getMessage();
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(resourceNotFoundException.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .zonedDateTime(ZonedDateTime.now(ZoneId.of("Z")))
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
