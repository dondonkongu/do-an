package com.thanhdon.product_service.dto.request;

import com.thanhdon.product_service.entity.ProductColor;
import com.thanhdon.product_service.entity.SubSubcategory;
import com.thanhdon.product_service.entity.Subcategory;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    String description;
    BigDecimal price;
    Integer quantity;
    Subcategory subcategory;
    SubSubcategory subsubcategory;
    List<ProductColor> colors;



}

