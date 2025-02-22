package com.example.productservice.service;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.model.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Integer id);

    List<Product> getAllProducts();

    Product createProduct(ProductDTO productDTO);

    Product updateProduct(Integer id, ProductDTO productDTO);

    Product deleteProduct(Integer id);
}
