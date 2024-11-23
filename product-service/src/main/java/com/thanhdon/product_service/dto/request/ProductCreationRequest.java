package com.thanhdon.product_service.dto.request;

import com.thanhdon.product_service.entity.Category;
import com.thanhdon.product_service.entity.ProductImage;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCreationRequest {

    String name;
    String code;
    String description;
    Long categoryId;
    @OneToMany
    List<ProductImage> images;
    Instant createdDate;
    Instant updatedDate;




}

