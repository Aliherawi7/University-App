package com.mycompany.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class ErrorResponse {
    private HttpStatus httpStatus;
    private int statusCode;
    private String message;
}

