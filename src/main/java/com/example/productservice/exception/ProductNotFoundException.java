package com.example.productservice.exception;

import com.example.productservice.dto.ErrorDTO;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException() {}

    public ProductNotFoundException(String message) {
        super(message);
    }
}
