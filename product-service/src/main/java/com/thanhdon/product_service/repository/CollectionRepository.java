package com.thanhdon.product_service.repository;

import com.thanhdon.product_service.entity.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<Collection,Long> {
}
