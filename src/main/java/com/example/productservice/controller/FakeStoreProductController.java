package com.example.productservice.controller;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.model.Product;
import com.example.productservice.service.FakeStoreProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FakeStoreProductController {

    private FakeStoreProductService fakeStoreProductService;

    public FakeStoreProductController(FakeStoreProductService fakeStoreProductService) {
        this.fakeStoreProductService = fakeStoreProductService;
    }

    @GetMapping("/hello")
    public String HelloController(){
        return "hello";
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return fakeStoreProductService.getProduct(id);

    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return fakeStoreProductService.getAllProducts();
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody ProductDTO product) {
        return fakeStoreProductService.createProduct(product);
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody ProductDTO product) {
        return fakeStoreProductService.updateProduct(id, product);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        return fakeStoreProductService.deleteProduct(id);
    }

}
