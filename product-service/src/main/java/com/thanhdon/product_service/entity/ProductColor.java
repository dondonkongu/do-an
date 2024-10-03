package com.thanhdon.product_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String colorName;

    @ManyToOne
    Product product;

    String colorCode;




}


