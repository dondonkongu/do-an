package com.thanhdon.product_service.dto.request;

import com.thanhdon.product_service.entity.ProductImage;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    BigDecimal price;
    String material;
    Long categoryId;
    String origin;
    Double discount;
    List<ProductImageCreationRequest> images ;




}

