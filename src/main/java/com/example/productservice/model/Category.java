package com.example.productservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends BaseModel{

    private String name;

    @OneToMany(mappedBy = "category",cascade = {CascadeType.REMOVE},fetch = FetchType.LAZY)
    List<Product> myProducts;

}
