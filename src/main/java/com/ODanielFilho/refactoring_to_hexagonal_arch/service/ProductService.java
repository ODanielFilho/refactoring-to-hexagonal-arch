package com.ODanielFilho.refactoring_to_hexagonal_arch.service;

import com.ODanielFilho.refactoring_to_hexagonal_arch.entity.Product;
import com.ODanielFilho.refactoring_to_hexagonal_arch.entity.dto.ProductDTO;
import com.ODanielFilho.refactoring_to_hexagonal_arch.mappers.Mappers;
import com.ODanielFilho.refactoring_to_hexagonal_arch.repository.ProductRepositpry;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepositpry repository;
    private final Mappers mapper;

    public ProductService(ProductRepositpry repository, Mappers mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProductDTO createProduct(ProductDTO dto) {
        if (dto.price() == null || dto.price().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        if (dto.name() == null || dto.name().isBlank()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }

        Product product = mapper.toEntity(dto);
        Product savedProduct = repository.save(product);
        return mapper.toDto(savedProduct);
    }

    public List<ProductDTO> getProducts() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public Optional<ProductDTO> findProductById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto);
    }

    public ProductDTO updateProduct(Long id, ProductDTO dto) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        if (dto.name() == null || dto.name().isBlank()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }

        if (dto.price() == null || dto.price().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }

        product.setName(dto.name());
        product.setPrice(dto.price());

        Product updatedProduct = repository.save(product);

        return mapper.toDto(updatedProduct);
    }


    public void deleteProduct(Long id) {
        Optional<Product> product = repository.findById(id);
        repository.deleteById(id);
    }
}
