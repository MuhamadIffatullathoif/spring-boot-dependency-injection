package com.iffat.springboot.di.repositories;

import com.iffat.springboot.di.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "Mouse", 200L),
                new Product(2L, "Keyboard", 300L),
                new Product(3L, "Monitor", 1000L),
                new Product(4L, "Motherboard", 1500L)
        );
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }
}
