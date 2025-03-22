package com.example.productservice.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreProductDTO {

    private Integer id;
    private String title;
    private String category;
    private String description;
    private String image;

}
