package com.ODanielFilho.refactoring_to_hexagonal_arch.infrastructure.config;

import com.ODanielFilho.refactoring_to_hexagonal_arch.core.ports.out.ProductRepositoryPort;
import com.ODanielFilho.refactoring_to_hexagonal_arch.core.usecases.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductService productService(ProductRepositoryPort repositoryPort) {
        return new ProductService(repositoryPort);
    }
}