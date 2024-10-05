package com.thanhdon.product_service.dto.response;

import com.thanhdon.product_service.entity.ProductColor;
import com.thanhdon.product_service.entity.SubSubcategory;
import com.thanhdon.product_service.entity.Subcategory;
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

    String name;
    String description;
    BigDecimal price;
    Integer quantity;
    Subcategory subcategory;
    SubSubcategory subsubcategory;
    List<ProductColor> colors;



}

