package com.mycompany.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private ZonedDateTime zonedDateTime;
    private HttpStatus httpStatus;
    private int statusCode;
    private String message;
}
