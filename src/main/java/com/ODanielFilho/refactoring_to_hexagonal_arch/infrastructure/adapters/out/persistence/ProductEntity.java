package com.ODanielFilho.refactoring_to_hexagonal_arch.infrastructure.adapters.out.persistence;

import com.ODanielFilho.refactoring_to_hexagonal_arch.core.domain.Product;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;

    public ProductEntity(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductEntity() {
    }

    public static ProductEntity fromDomain(Product product) {
        return new ProductEntity(product.getId(), product.getName(), product.getPrice());
    }

    public Product toDomain() {
        return new Product(this.id, this.name, this.price);
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
