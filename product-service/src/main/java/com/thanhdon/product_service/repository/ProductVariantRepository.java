package com.thanhdon.product_service.repository;

import com.thanhdon.product_service.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductVariantRepository extends JpaRepository<ProductVariant ,Long> {

    List<ProductVariant> findAllByProductId(Long id);
}
