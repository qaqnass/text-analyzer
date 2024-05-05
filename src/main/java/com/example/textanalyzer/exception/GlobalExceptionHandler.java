package com.example.textanalyzer.exception;

import com.example.textanalyzer.models.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * The purpose of GlobalExceptionHandler exception class is to customize the exception, we customize the way that through the actual error to client
 * We have to tell spring that {@link GlobalExceptionHandler } will be a serve of multiple exception {{@link ControllerAdvice}}
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    // We have to tell spring that the handleApiRequestException, is the function responsible for the exception
    @ExceptionHandler(value = {ApiExceptionHandler.class})
    public ResponseEntity<Object> handleApiRequestException(ApiExceptionHandler exception) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiExceptoin = new ApiException(
                exception.getMessage(),
                ZonedDateTime.now(ZoneId.of("Z")),
                badRequest
        );

        return new ResponseEntity<>(apiExceptoin, badRequest);
    }
}
