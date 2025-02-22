package com.example.productservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Category extends BaseModel{

    private String name;

    @OneToMany(mappedBy = "category",cascade = {CascadeType.REMOVE},fetch = FetchType.LAZY)
    List<Product> myProducts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getMyProducts() {
        return myProducts;
    }

    public void setMyProducts(List<Product> myProducts) {
        this.myProducts = myProducts;
    }

}
