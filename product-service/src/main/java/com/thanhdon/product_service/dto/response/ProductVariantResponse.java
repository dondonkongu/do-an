package com.thanhdon.product_service.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductVariantResponse {
    Long id;
    Long productId;
    String color;
    String size;
    Integer stock;
    Integer sold;








}

