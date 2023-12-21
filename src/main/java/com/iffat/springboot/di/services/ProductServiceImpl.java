package com.iffat.springboot.di.services;

import com.iffat.springboot.di.models.Product;
import com.iffat.springboot.di.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    // @Autowired
    // private Environment environment;

    @Autowired
    @Qualifier("productRepositoryFoo")
    private ProductRepository repository;

    @Value("${config.price.tax}")
    private Double tax;

    /* Constructor injection can use annotation autowired or no */
//    public ProductServiceImpl(ProductRepository repository) {
//        this.repository = repository;
//    }

    /* Setter Injection required autowired annotation */
//    @Autowired
//    public void setRepository(ProductRepository repository) {
//        this.repository = repository;
//    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(product -> {
            // Double tax = environment.getProperty("config.price.tax", Double.class);
            Double priceTax = product.getPrice() * tax;
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
