package com.thanhdon.product_service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
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

