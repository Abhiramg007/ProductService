package com.example.productservice.controller;

import com.example.productservice.dto.CategoryDTO;
import com.example.productservice.dto.ProductDTO;
import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.model.Category;
import com.example.productservice.model.Product;
import com.example.productservice.service.ProductService;
import com.example.productservice.service.SelfCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private  SelfCategoryService categoryService;

    @Autowired
    @Qualifier("selfProductService")
    private ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/hello")
    public String HelloController(){
        return "hello";
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Integer id) throws ProductNotFoundException {
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
    public Product updateProduct(@PathVariable Integer id, @RequestBody ProductDTO product) throws ProductNotFoundException {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/product/{id}")
    public Product deleteProduct(@PathVariable Integer id) throws ProductNotFoundException {

        return productService.deleteProduct(id);
    }

    @GetMapping("/category/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/category")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/category")
    public Category addCategory(@RequestBody CategoryDTO category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/category/{id}")
    public Category updateCategory(@PathVariable Integer id, @RequestBody CategoryDTO category) {
        return categoryService.updateCategory(id,category);
    }

    @DeleteMapping("/category/{id}")
    public Category deleteCategory(@PathVariable Integer id) {
        return categoryService.deleteCategory(id) ;
    }
}
