package com.order.order_service.exceptions;

public class InvalidOrderException extends RuntimeException{

    public InvalidOrderException(String message){
        super(message);
    }
}
