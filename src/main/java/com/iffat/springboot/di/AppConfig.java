package com.iffat.springboot.di;

import com.iffat.springboot.di.repositories.ProductRepositoryJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean
    ProductRepositoryJson productRepositoryJson(){
        return new ProductRepositoryJson();
    }
}
