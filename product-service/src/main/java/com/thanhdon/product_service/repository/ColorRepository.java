package com.thanhdon.product_service.repository;

import com.thanhdon.product_service.entity.ProductColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<ProductColor,String> {
}
