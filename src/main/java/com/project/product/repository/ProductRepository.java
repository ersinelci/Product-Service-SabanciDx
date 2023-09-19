package com.project.product.repository;

import com.project.product.entity.ProductEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
    List<ProductEntity> findByNameContainingAndCodeContainingAndBrandContainingAndPriceBetween(
        String name, String code, String brand, double minPrice, double maxPrice);
}
