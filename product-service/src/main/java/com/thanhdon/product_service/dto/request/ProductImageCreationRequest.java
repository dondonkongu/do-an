package com.thanhdon.product_service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductImageCreationRequest {
    Long productId;
    Long colorId;
    String imageUrl;
    Boolean isMain ;


}

