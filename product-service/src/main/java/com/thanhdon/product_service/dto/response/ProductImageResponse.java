package com.thanhdon.product_service.dto.response;

import com.thanhdon.product_service.entity.ProductColor;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductImageResponse {
    Long imageId;
    String imageUrl;
    ProductColor color;
    Boolean isMain ;



}

