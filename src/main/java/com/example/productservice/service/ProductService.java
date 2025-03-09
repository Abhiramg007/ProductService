package com.example.productservice.service;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.model.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Integer id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(ProductDTO productDTO);

    Product updateProduct(Integer id, ProductDTO productDTO) throws ProductNotFoundException;

    Product deleteProduct(Integer id) throws ProductNotFoundException;
}
