package com.thanhdon.product_service.dto.response;

import com.thanhdon.product_service.dto.request.ProductImageCreationRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;
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
    Integer totalSold;
    CategoryResponse category;
    Instant createdDate;
    Instant updatedDate;
    List<ProductImageResponse> images;



}

