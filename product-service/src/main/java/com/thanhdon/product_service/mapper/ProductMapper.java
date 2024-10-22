package com.thanhdon.product_service.mapper;

import com.thanhdon.product_service.dto.request.ProductCreationRequest;
import com.thanhdon.product_service.dto.response.ProductResponse;
import com.thanhdon.product_service.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface ProductMapper {
    @Mapping(target = "sizes", ignore = true)

    public Product toProduct(ProductCreationRequest request);
    public ProductResponse toProductResponse(Product product);
}
