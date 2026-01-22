package com.ODanielFilho.refactoring_to_hexagonal_arch.controller;

import com.ODanielFilho.refactoring_to_hexagonal_arch.entity.dto.ProductDTO;
import com.ODanielFilho.refactoring_to_hexagonal_arch.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO dto) {
        ProductDTO created = service.createProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // READ - ALL
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        return ResponseEntity.ok(service.getProducts());
    }

    // READ - BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Long id) {
        return service.findProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(
            @PathVariable Long id,
            @RequestBody ProductDTO dto
    ) {
        ProductDTO updated = service.updateProduct(id, dto);
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

