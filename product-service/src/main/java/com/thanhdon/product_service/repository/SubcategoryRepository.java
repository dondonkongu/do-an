package com.thanhdon.product_service.repository;


import com.thanhdon.product_service.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepository extends JpaRepository<Long, Subcategory> {
}
