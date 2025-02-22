package com.example.productservice.repositry;

import com.example.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface MyCategoryRepo extends JpaRepository<Category, Integer> {
    Category findByName(String name);
}
