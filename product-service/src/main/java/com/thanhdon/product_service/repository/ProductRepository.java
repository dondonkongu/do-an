package com.thanhdon.product_service.repository;


import com.thanhdon.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


    boolean existsByName(String name);
}
