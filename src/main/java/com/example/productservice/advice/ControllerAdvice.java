package com.example.productservice.advice;

import com.example.productservice.dto.ErrorDTO;
import com.example.productservice.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException() {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("Product Not Found");
        errorDTO.setCode("400");

        return ResponseEntity.badRequest().body(errorDTO);
    }
}
