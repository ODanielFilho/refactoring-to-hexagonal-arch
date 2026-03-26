package com.ODanielFilho.refactoring_to_hexagonal_arch.core.usecases;

import com.ODanielFilho.refactoring_to_hexagonal_arch.core.domain.Product;
import com.ODanielFilho.refactoring_to_hexagonal_arch.core.ports.in.ProductServicePort;
import com.ODanielFilho.refactoring_to_hexagonal_arch.core.ports.out.ProductRepositoryPort;

import java.util.List;
import java.util.Optional;

public class ProductService implements ProductServicePort {
    private final ProductRepositoryPort repositoryPort;

    public ProductService(ProductRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Product createProduct(Product product) {
        product.validate();
        return repositoryPort.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return repositoryPort.findAll();
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return repositoryPort.findById(id);
    }

    @Override
    public Product updateProduct(Long id, Product productUpdate) {
        Product existingProduct = repositoryPort.findById(id)
                .orElse(null);
        if(repositoryPort.existsById(id)) {
            productUpdate.validate();
            existingProduct.updateInfo(productUpdate.getName(), productUpdate.getPrice());

            return repositoryPort.save(existingProduct);
        }
        return null;
    }

    @Override
    public List<Product> findByNome(String nome) {
        return repositoryPort.findByNome(nome);
    }

    @Override
    public void deleteProduct(Long id) {
        if (repositoryPort.existsById(id)) {
            repositoryPort.deleteById(id);
        }
    }
}
