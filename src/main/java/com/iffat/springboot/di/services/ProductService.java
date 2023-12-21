package com.iffat.springboot.di.services;

import com.iffat.springboot.di.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
}
