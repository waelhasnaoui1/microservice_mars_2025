package com.order.order_service.exceptions;

import com.order.order_service.dto.GlobalErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<GlobalErrorResponse> handleOrderNotFound(OrderNotFoundException ex){
        GlobalErrorResponse error = new GlobalErrorResponse(
                ex.getMessage(),
                "Order Not Found",
                HttpStatus.NOT_FOUND.value()
        );

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidOrderException.class)
    public ResponseEntity<GlobalErrorResponse> handleInvalidOrder(InvalidOrderException ex){
        GlobalErrorResponse error = new GlobalErrorResponse(
                ex.getMessage(),
                "Invalid Order",
                HttpStatus.BAD_REQUEST.value()
        );

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalErrorResponse> handleGeneralException(Exception ex){
        GlobalErrorResponse error = new GlobalErrorResponse(
                "An unexpected error occurred: " + ex.getMessage(),
                "Internal Server Error",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
