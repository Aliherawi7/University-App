package com.mycompany.fieldofstudyservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest){
        String errorDetails = resourceNotFoundException.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), errorDetails);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
