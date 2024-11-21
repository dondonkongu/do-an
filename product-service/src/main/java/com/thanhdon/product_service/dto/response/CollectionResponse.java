package com.thanhdon.product_service.dto.response;



import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CollectionResponse {
    Long id;
    String name;
    String description;
    String url;
    List<ProductResponse> products;

}
