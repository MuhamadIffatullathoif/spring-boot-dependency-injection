package com.iffat.springboot.di.repositories;

import com.iffat.springboot.di.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepositoryFoo implements ProductRepository{
    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product("6584cb81418538663e87d12c", "Mouse", 300L));
    }

    @Override
    public Product findById(String id) {
        return new Product("6584cb817ee9820fb1e6b25b", "Mouse", 300L);
    }
}
