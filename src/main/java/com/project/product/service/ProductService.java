package com.project.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.product.entity.ProductEntity;
import com.project.product.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity createProduct(ProductEntity product) {
        // Implement product creation logic here
        return productRepository.save(product);
    }

    public List<ProductEntity> searchProducts(String name, String code, String brand, Double minPrice, Double maxPrice) {
        // Implement product search logic here
        return productRepository.findByNameContainingAndCodeContainingAndBrandContainingAndPriceBetween(
            name, code, brand, minPrice, maxPrice);
    }

    public ProductEntity getProduct(Long id) {
        // Implement product retrieval logic here
        return productRepository.findById(id).orElse(null);
    }

    public ProductEntity updateProduct(Long id, ProductEntity product) {
        // Implement product update logic here
        ProductEntity existingProduct = getProduct(id);
        if (existingProduct != null) {
            // Update the fields of existingProduct with the new values from the 'product' parameter
            // Save the updated product
            return productRepository.save(existingProduct);
        }
        return null;
    }

    public boolean deleteProduct(Long id) {
        // Implement product deletion logic here
        ProductEntity existingProduct = getProduct(id);
        if (existingProduct != null) {
            productRepository.delete(existingProduct);
            return true;
        }
        return false;
    }
}
