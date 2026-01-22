package com.ODanielFilho.refactoring_to_hexagonal_arch.repository;

import com.ODanielFilho.refactoring_to_hexagonal_arch.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
