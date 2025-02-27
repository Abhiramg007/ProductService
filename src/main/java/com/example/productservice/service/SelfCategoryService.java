package com.example.productservice.service;

import com.example.productservice.dto.CategoryDTO;
import com.example.productservice.model.Category;
import com.example.productservice.repositry.MyCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfCategoryService {

    @Autowired
    private MyCategoryRepo myCategoryRepo;

    public Category getCategoryById(int id) {
        return myCategoryRepo.findById(id).get();
    }

    public List<Category> getAllCategories() {
        return myCategoryRepo.findAll();
    }

    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());

        myCategoryRepo.save(category);
        return category;
    }

    public Category updateCategory(Integer id, CategoryDTO category) {
        Category categoryOld = myCategoryRepo.findById(id).get();
        categoryOld.setName(category.getName());

        return myCategoryRepo.save(categoryOld);
    }

    public Category deleteCategory(Integer id) {
        Category category = myCategoryRepo.findById(id).get();
        category.setDeleted(true);
        return myCategoryRepo.save(category);
    }
}
