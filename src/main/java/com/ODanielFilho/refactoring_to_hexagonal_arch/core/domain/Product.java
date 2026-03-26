package com.ODanielFilho.refactoring_to_hexagonal_arch.core.domain;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String name;
    private BigDecimal price;

    public Product(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void validate() {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Invalid name");
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Invalid price");
    }

    public void updateInfo(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.validate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
