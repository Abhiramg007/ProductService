package com.example.productservice.controller;

import com.example.productservice.dto.CategoryDTO;
import com.example.productservice.dto.ProductDTO;
import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.model.Category;
import com.example.productservice.model.Product;
import com.example.productservice.repositry.MyCategoryRepo;
import com.example.productservice.service.ProductService;
import com.example.productservice.service.SelfCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private SelfCategoryService categoryService;

    private ProductService productService;

    @Autowired
    private MyCategoryRepo myCategoryRepo;

    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/hello")
    public String HelloController(){
        return "hello";
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Integer id) throws ProductNotFoundException {
        Product product = productService.getProductById(id);
        return product;

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

        Product product = productService.getProductById(id);
        return product;
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
