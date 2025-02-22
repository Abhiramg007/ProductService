package com.example.productservice.repositry;

import com.example.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface MyProductRepo extends JpaRepository<Product, Integer> {
}
