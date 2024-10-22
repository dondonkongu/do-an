package com.thanhdon.product_service.repository;


import com.thanhdon.product_service.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductImageRepository extends JpaRepository<ProductImage,Long> {

    Optional<ProductImage> findProductImageByProductId(Long productId) ;


}
