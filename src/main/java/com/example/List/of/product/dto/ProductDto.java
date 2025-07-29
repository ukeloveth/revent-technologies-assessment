package com.example.List.of.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Getter
@Slf4j
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private  double price;


    public ProductDto(Long id, String name, String brand, Double price) {
        this.id = id;
        this.name = name;
        this.description = brand;
        this.price = price;
    }

}
