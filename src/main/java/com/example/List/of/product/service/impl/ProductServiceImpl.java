package com.example.List.of.product.service.impl;

import com.example.List.of.product.dto.ProductDto;
import com.example.List.of.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductDto> products = new ArrayList<>();
        products.add(new ProductDto(1L, "Laptop", "Dell", 300.00));
        products.add(new ProductDto(2L, "Tablet", "Dell", 500.00));
        return products;
    }
}
