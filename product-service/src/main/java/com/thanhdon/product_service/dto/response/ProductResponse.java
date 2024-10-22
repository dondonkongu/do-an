package com.thanhdon.product_service.dto.response;

import com.thanhdon.product_service.dto.request.ProductImageCreationRequest;
import com.thanhdon.product_service.entity.Category;
import com.thanhdon.product_service.entity.ProductImage;
import com.thanhdon.product_service.entity.Size;
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
    Long id;
    String name;
    String description;
    BigDecimal price;
    Integer quantity;
    String subcategory;
    String material;
    List<Size> sizes;
    Integer soldQuantity;
    String category;
    List<ProductImageResponse> productImages;
    String origin;
    Double discount;



}

