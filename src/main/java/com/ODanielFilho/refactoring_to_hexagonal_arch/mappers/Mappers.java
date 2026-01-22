package com.ODanielFilho.refactoring_to_hexagonal_arch.mappers;

import com.ODanielFilho.refactoring_to_hexagonal_arch.entity.Product;
import com.ODanielFilho.refactoring_to_hexagonal_arch.entity.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class Mappers {
    public Product toEntity(ProductDTO dto) {
        if (dto == null) return null;

        return new Product(
                null,
                dto.name(),
                dto.price()
        );
    }

    public ProductDTO toDto(Product entity) {
        if (entity == null) return null;

        return new ProductDTO(
                entity.getName(),
                entity.getPrice()
        );
    }
}
