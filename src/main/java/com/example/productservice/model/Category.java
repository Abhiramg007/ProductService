package com.example.productservice.model;

import jakarta.persistence.Entity;

@Entity
public class Category extends BaseModel{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
