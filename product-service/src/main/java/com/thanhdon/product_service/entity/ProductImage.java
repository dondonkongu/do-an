package com.thanhdon.product_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long imageId;

    String url;
    String color;
    @OneToMany
    List<Size> sizes;
    Boolean isMain ;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    Product product;


}
