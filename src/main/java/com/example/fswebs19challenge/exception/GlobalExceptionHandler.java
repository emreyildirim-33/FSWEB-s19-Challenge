package com.example.fswebs19challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<TwitterErrorResponse> handleException(RuntimeException ex) {
        TwitterErrorResponse twitterErrorResponse = new TwitterErrorResponse();

        twitterErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        twitterErrorResponse.setMessage(ex.getMessage());
        twitterErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(twitterErrorResponse,HttpStatus.BAD_REQUEST);
    }
}
