package com.thanhdon.product_service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;


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
    Double price;
    Long categoryId;
    Integer totalSold;
    String material;
    Long subCategoryId;
    List<ProductImageCreationRequest> images;




}

