package com.soaringroad.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    /**
     * Error Handle
     * @param t object extends throwable
     * @return response
     */
    @ExceptionHandler(value = Throwable.class)
    public ResponseEntity<?> errorHandle(Throwable t) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
