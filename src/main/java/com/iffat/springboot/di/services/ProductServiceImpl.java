package com.iffat.springboot.di.services;

import com.iffat.springboot.di.models.Product;
import com.iffat.springboot.di.repositories.ProductRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService{

    private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(product -> {
            Double priceTax = product.getPrice() * 1.25d;
            // Product newProduct = new Product(product.getId(), product.getName(), priceImp.longValue());
            Product newProduct = product.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
