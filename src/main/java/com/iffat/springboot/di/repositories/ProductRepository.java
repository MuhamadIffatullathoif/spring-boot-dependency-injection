package com.iffat.springboot.di.repositories;

import com.iffat.springboot.di.models.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(String id);
}
