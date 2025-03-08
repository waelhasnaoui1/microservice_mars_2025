package com.product.product_service.dto;

import lombok.Data;

@Data
public class GlobalErrorResponse {
    private String error;
    private String message;
    private int statusCode;

    public GlobalErrorResponse(String error, String message, int statusCode) {
        this.error = error;
        this.message = message;
        this.statusCode = statusCode;
    }

}
