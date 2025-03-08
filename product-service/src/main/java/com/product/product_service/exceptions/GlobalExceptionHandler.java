package com.product.product_service.exceptions;

import com.product.product_service.dto.GlobalErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<GlobalErrorResponse> handleProductNotFoundException(ProductNotFoundException ex){
        GlobalErrorResponse error = new GlobalErrorResponse(
                ex.getMessage(),
                "Product Error",
                HttpStatus.NOT_FOUND.value()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalErrorResponse> handleProductException(Exception ex){
        GlobalErrorResponse error = new GlobalErrorResponse(
                ex.getMessage(),
                "UNKNOWN Error",
                HttpStatus.FORBIDDEN.value()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
