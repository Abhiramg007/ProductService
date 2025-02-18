package com.example.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FakeStoreProductController {

    @GetMapping("/hello")
    public String HelloController(){
        return "hello";
    }
}
