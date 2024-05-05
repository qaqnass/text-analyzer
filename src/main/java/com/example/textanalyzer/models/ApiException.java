package com.example.textanalyzer.models;

import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;

/**
 * Custom exception class for API-related errors.
 * This exception is used to represent errors that occur during API operations,
 * such as invalid requests, authentication failures, or unexpected server errors.
 * It provides information about the error status, message, and time.
 */
public class ApiException {
    private final String message;
    private final ZonedDateTime dateTime;
    private final HttpStatus httpStatus;

    public ApiException(String message, ZonedDateTime dateTime, HttpStatus httpStatus) {
        this.message = message;
        this.dateTime = dateTime;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
