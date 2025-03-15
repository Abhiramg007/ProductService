package com.example.productservice.service;

import com.example.productservice.dto.CategoryDTO;
import com.example.productservice.dto.ProductDTO;
import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.model.Category;
import com.example.productservice.model.Product;
import com.example.productservice.repositry.MyCategoryRepo;
import com.example.productservice.repositry.MyProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    @Autowired
    private MyProductRepo myProductRepo;

    @Autowired
    private MyCategoryRepo myCategoryRepo;

    @Override
    public Product getProductById(Integer id) throws ProductNotFoundException {
        Optional<Product> product = myProductRepo.findById(id);
        if(!product.isPresent()){
            throw new ProductNotFoundException("product not found");
        }
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {

        return myProductRepo.findAll();
    }

    @Transactional
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

        product.setCategory(existingcategory);
        myProductRepo.save(product);
        return product;
    }

    @Transactional
    @Override
    public Product updateProduct(Integer id, ProductDTO productDTO) throws ProductNotFoundException {
        Optional<Product> list = myProductRepo.findById(id);
        if(!list.isPresent()){
            throw new ProductNotFoundException("product not found");
        }

        Product product =list.get();
        product.setDescription(productDTO.getDescription());
        product.setTitle(productDTO.getTitle());
        product.setUpdatedAt(new Date());
        product.setImageURL(productDTO.getImageURL());
        myProductRepo.save(product);
        return product;
    }

    @Transactional
    @Override
    public Product deleteProduct(Integer id) throws ProductNotFoundException {
        Optional<Product> list = myProductRepo.findById(id);
        if(!list.isPresent()){
            throw new ProductNotFoundException("product not found");
        }
        Product product = list.get();
        product.setDeleted(true);
        return product;
    }

}
