package com.example.productservice.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer id;
    private String title;
    private String description;
    private String imageURL;
    private CategoryDTO category;
}
