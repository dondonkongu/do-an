package com.thanhdon.product_service.repository;

import com.thanhdon.product_service.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SizeRepository extends JpaRepository<Size,String> {


}
