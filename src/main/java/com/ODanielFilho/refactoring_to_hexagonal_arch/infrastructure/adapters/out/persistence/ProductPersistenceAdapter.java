package com.ODanielFilho.refactoring_to_hexagonal_arch.infrastructure.adapters.out.persistence;

import com.ODanielFilho.refactoring_to_hexagonal_arch.core.domain.Product;
import com.ODanielFilho.refactoring_to_hexagonal_arch.core.ports.out.ProductRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductPersistenceAdapter implements ProductRepositoryPort {
    private final ProductJpaRepository jpaRepository;

    public ProductPersistenceAdapter(ProductJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = ProductEntity.fromDomain(product);
        return jpaRepository.save(entity).toDomain();
    }

    @Override
    public List<Product> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(ProductEntity::toDomain)
                .toList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaRepository.findById(id)
                .map(ProductEntity::toDomain);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Product> findByNome(String nome) {
        return jpaRepository.findByNome(nome).stream().map(ProductEntity::toDomain).toList();
    }
}
