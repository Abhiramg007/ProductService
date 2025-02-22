package com.example.productservice.controller;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.model.Product;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/hello")
    public String HelloController(){
        return "hello";
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);

    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody ProductDTO product) {
        return productService.createProduct(product);
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody ProductDTO product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/product/{id}")
    public Product deleteProduct(@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }

}
