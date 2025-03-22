package com.example.productservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel{


    private String imageURL;
    private String title;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Category category;


}
