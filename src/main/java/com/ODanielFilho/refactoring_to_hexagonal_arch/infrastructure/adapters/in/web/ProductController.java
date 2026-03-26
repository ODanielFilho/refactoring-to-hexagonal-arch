package com.ODanielFilho.refactoring_to_hexagonal_arch.infrastructure.adapters.in.web;

import com.ODanielFilho.refactoring_to_hexagonal_arch.core.domain.Product;
import com.ODanielFilho.refactoring_to_hexagonal_arch.core.ports.in.ProductServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServicePort productServicePort;

    public ProductController(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductRequestDTO dto) {
        Product created = productServicePort.createProduct(dto.toDomain());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // READ - ALL
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productServicePort.getProducts());
    }

    // READ - BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return productServicePort.findProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> getByNome(@RequestParam String nome) {
        return ResponseEntity.ok(productServicePort.findByNome(nome));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody ProductRequestDTO dto) {
        Product updated = productServicePort.updateProduct(id, dto.toDomain());

        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productServicePort.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

