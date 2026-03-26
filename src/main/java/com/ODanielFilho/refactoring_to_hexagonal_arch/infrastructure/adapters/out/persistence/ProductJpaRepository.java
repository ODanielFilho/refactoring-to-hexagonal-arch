package com.ODanielFilho.refactoring_to_hexagonal_arch.infrastructure.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT p FROM ProductEntity p WHERE p.name LIKE %:nome%")
    List<ProductEntity> findByNome(@Param("nome") String nome);
}
