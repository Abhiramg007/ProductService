package com.example.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreProductDTO {

    private Integer id;
    private String title;
    private String category;
    private String description;
    private String image;

}
