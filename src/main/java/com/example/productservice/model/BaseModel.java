package com.example.productservice.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date createdAt;
    private Date updatedAt;
    private boolean isDeleted;

}
