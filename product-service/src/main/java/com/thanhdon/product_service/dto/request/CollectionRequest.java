package com.thanhdon.product_service.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CollectionRequest {
    String name;
    String description;
    String url;
    List<Long> productIds;

}
