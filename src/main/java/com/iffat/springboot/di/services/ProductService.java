package com.iffat.springboot.di.services;

import com.iffat.springboot.di.models.Product;
import com.iffat.springboot.di.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private ProductRepository repository = new ProductRepository();
    public List<Product> findAll() {
        return repository.findAll().stream().map(product -> {
            Double priceImp = product.getPrice() * 1.25d;
            product.setPrice(priceImp.longValue());
            return product;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }
}
