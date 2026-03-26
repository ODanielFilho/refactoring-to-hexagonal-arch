package com.ODanielFilho.refactoring_to_hexagonal_arch.core.ports.out;

import com.ODanielFilho.refactoring_to_hexagonal_arch.core.domain.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {
    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById(Long id);
    boolean existsById(Long id);
    void deleteById(Long id);
    List<Product> findByNome(String nome);
}