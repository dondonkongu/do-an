package com.thanhdon.product_service.dto.request;

import com.thanhdon.product_service.entity.SubSubcategory;
import com.thanhdon.product_service.entity.Subcategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCreationRequest {

    String name;
    String description;
    BigDecimal price;
    Integer quantity;
    Subcategory subcategory;
    SubSubcategory subsubcategory;




}

