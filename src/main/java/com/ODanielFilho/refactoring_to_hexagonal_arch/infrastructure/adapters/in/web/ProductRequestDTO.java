package com.ODanielFilho.refactoring_to_hexagonal_arch.infrastructure.adapters.in.web;

import com.ODanielFilho.refactoring_to_hexagonal_arch.core.domain.Product;

import java.math.BigDecimal;

public record ProductRequestDTO( String name, BigDecimal price) {
    public Product toDomain() {
        return new Product(null, name, price);
    }
}
