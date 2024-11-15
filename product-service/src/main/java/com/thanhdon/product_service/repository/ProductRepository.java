package com.thanhdon.product_service.repository;


import com.thanhdon.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByName(String name);

    @Query(value = "select p from Product p WHERE p.name like %:name% ")
    List<Product> findByNameLike(@Param("name") String name);

//    @Query(value = "SELECT p.* FROM product p JOIN product_image i ON p.id = i.product_id JOIN size s ON i.id = s.product_image_id WHERE i.color = :color AND s.name = :size", nativeQuery = true)
//    List<Product> findByColorAndSize(@Param("color") String color, @Param("size") String size);

    @Query(value = "SELECT p FROM Product p " +
            "JOIN p.images i " +
            "JOIN i.sizes s " +
            "WHERE (:color IS NULL OR i.color IN :color) " +
            "AND (:size IS NULL OR s.name IN :size)")
    List<Product> findByColorAndSize(@Param("color") List<String> color, @Param("size") List<String> size);

}
