package com.thanhdon.product_service.dto.response;

import com.thanhdon.product_service.dto.request.ProductImageCreationRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    Long id;
    String name;
    String code;
    String description;
    BigDecimal price;
    String material;
    CategoryResponse category;
    String origin;
    Double discount;
    List<ProductImageResponse> images;



}

