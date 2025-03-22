package com.example.productservice.service;

import com.example.productservice.dto.CategoryDTO;
import com.example.productservice.model.Category;
import com.example.productservice.repositry.MyCategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SelfCategoryService {

    private final MyCategoryRepo myCategoryRepo;

    public Category getCategoryById(int id) {
        return myCategoryRepo.findById(id).get();
    }

    public List<Category> getAllCategories() {
        return myCategoryRepo.findAll();
    }

    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDeleted(false);
        category.setCreatedAt(new Date());
        category.setUpdatedAt(new Date());

        myCategoryRepo.save(category);
        return category;
    }

    public Category updateCategory(Integer id, CategoryDTO category) {
        Category categoryOld = myCategoryRepo.findById(id).get();
        categoryOld.setName(category.getName());
        categoryOld.setUpdatedAt(new Date());
        categoryOld.setDeleted(false);
        categoryOld.setCreatedAt(categoryOld.getCreatedAt());

        return myCategoryRepo.save(categoryOld);
    }

    public Category deleteCategory(Integer id) {
        Category category = myCategoryRepo.findById(id).get();
        category.setDeleted(true);
        return myCategoryRepo.save(category);
    }
}
