package com.thanhdon.product_service.repository;

import com.thanhdon.product_service.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    boolean existsByName(String name);
}
