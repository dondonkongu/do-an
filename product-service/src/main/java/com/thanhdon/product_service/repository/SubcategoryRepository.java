package com.thanhdon.product_service.repository;


import com.thanhdon.product_service.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {

    List<Subcategory> findAllByNameIn(List<String> names);
}
