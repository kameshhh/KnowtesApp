package com.app.knowtes.exceptions;

import com.app.knowtes.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceAlreadyPresentException.class)
    public ResponseEntity<ApiResponse> handleResourceAlreadyPresentException(
            ResourceAlreadyPresentException ex, WebRequest request
    ) {

        ApiResponse response = new ApiResponse(ex.getMessage(), false);
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex, WebRequest request
    ) {

        Map<String, String> errorResponse = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errorResponse.put(fieldName, errorMessage);
        });

        return new ResponseEntity<Map<String, String>>(errorResponse, HttpStatus.BAD_REQUEST);

    }

}
