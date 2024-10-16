package com.thanhdon.product_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String productCode;
    String description;
    BigDecimal price;
    @ManyToMany
    List<Size> sizes;
    String material;


    Integer quantity; // so luong ton kho
    Integer soldQuantity; // so luong da ban

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,orphanRemoval = true)
    List<ProductImage> productImages;

    @ManyToOne
    Subcategory subcategory;

    @ManyToOne
    Category category;

    String origin;
    Double discount;


}


