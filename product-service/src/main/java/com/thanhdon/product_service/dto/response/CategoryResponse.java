package com.thanhdon.product_service.dto.response;


import com.thanhdon.product_service.entity.Subcategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryResponse {
    String name;
    String description;

    List<Subcategory> subcategories;
}
