package com.ODanielFilho.refactoring_to_hexagonal_arch.core.ports.in;

import com.ODanielFilho.refactoring_to_hexagonal_arch.core.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServicePort {
    Product createProduct(Product product);
    List<Product> getProducts();
    Optional<Product> findProductById(Long id);
    Product updateProduct(Long id, Product product);
    List<Product> findByNome(String nome);
    void deleteProduct(Long id);
}
