package com.example.productservice.service;

import com.example.productservice.dto.CategoryDTO;
import com.example.productservice.dto.ProductDTO;
import com.example.productservice.model.Category;
import com.example.productservice.model.Product;
import com.example.productservice.repositry.MyCategoryRepo;
import com.example.productservice.repositry.MyProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    @Autowired
    private MyProductRepo myProductRepo;

    @Autowired
    private MyCategoryRepo myCategoryRepo;

    @Override
    public Product getProductById(Integer id) {
        Product product = myProductRepo.findById(id).get();
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return myProductRepo.findAll();
    }

    @Override
    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product();
        Category category = new Category();

        product.setImageURL(productDTO.getImageURL());
        product.setDescription(productDTO.getDescription());
        product.setTitle(productDTO.getTitle());
        product.setUpdatedAt(new Date());
        product.setCreatedAt(new Date());
        product.setDeleted(false);

        CategoryDTO categoryDTO = productDTO.getCategory();

        Category existingcategory = myCategoryRepo.findByName(categoryDTO.getName());

        if(existingcategory == null) {
            category.setName(categoryDTO.getName());
            category.setCreatedAt(new Date());
            category.setUpdatedAt(new Date());
            category.setDeleted(false);
            myCategoryRepo.save(category);
        }

        product.setCategory(category);
        myProductRepo.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Integer id, ProductDTO productDTO) {
        Product product = myProductRepo.findById(id).get();
        product.setDescription(productDTO.getDescription());
        product.setTitle(productDTO.getTitle());
        product.setUpdatedAt(new Date());
        product.setImageURL(productDTO.getImageURL());
        myProductRepo.save(product);
        return product;
    }

    @Override
    public Product deleteProduct(Integer id) {
        Product product = myProductRepo.findById(id).get();
        product.setDeleted(true);
        return product;
    }

}
