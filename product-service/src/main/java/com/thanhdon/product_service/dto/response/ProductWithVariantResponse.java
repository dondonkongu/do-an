package com.thanhdon.product_service.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductWithVariantResponse {
    Long id;
    String name;
    String description;
    Double price;
    String imageUrl;
    CategoryResponse category;
    List<ProductImageResponse> images;
    List<ProductVariantResponse> variants;
}
