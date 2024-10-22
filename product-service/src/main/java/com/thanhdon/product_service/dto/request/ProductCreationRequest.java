package com.thanhdon.product_service.dto.request;

import com.thanhdon.product_service.entity.Category;
import com.thanhdon.product_service.entity.ProductImage;
import com.thanhdon.product_service.entity.Size;
import com.thanhdon.product_service.entity.Subcategory;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToMany;
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
    String productCode;
    String description;
    BigDecimal price;
    List<String> sizes;
    String material;


    Integer quantity;
    Integer soldQuantity;

    List<ProductImageCreationRequest> productImages;

    String subcategory;
    String category;
    String origin;
    Double discount;




}

