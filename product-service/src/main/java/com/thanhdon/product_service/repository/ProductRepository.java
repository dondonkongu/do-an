package com.thanhdon.product_service.repository;


import com.thanhdon.product_service.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByName(String name);

    List<Product> findBySubCategoryId(Long id);


    @Query(value = "select p from Product p WHERE p.name like %:name% ")
    List<Product> findByNameLike(@Param("name") String name);


    @Query("select distinct p from Product p join ProductVariant v on p.id = v.product.id where (:categoryId is null or p.category.id in :categoryId) and (:subcategoryId is null or p.subCategory.id in :subcategoryId) and (:size is null or v.size in :size) and (:color is null or v.color in :color) ")
    List<Product> findProductByVariantAttributes(@Param("categoryId") List<Long> categoryId,@Param("subcategoryId") List<Long> subcategoryId,@Param("color") List<String> size,@Param("size") List<String> color);
//
////    @Query(value = "SELECT p.* FROM product p JOIN product_image i ON p.id = i.product_id JOIN size s ON i.id = s.product_image_id WHERE i.color = :color AND s.name = :size", nativeQuery = true)
////    List<Product> findByColorAndSize(@Param("color") String color, @Param("size") String size);
//
//    @Query(value = "SELECT p FROM Product p " +
//            "JOIN p.images i " +
//            "JOIN i.sizes s " +
//            "WHERE (:color IS NULL OR i.color IN :color) " +
//            "AND (:size IS NULL OR s.name IN :size)")
//    List<Product> findByColorAndSize(@Param("color") List<String> color, @Param("size") List<String> size);

}
