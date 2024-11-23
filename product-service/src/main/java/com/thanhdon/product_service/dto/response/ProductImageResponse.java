package com.thanhdon.product_service.dto.response;

import com.thanhdon.product_service.dto.request.SizeRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductImageResponse {
    Long id;
    String url;
    Boolean isMain ;

}

