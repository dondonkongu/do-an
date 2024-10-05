package com.thanhdon.product_service.mapper;

import com.thanhdon.product_service.dto.request.ProductCreationRequest;
import com.thanhdon.product_service.dto.response.ProductResponse;
import com.thanhdon.product_service.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ProductMapper {

    public Product toProduct(ProductCreationRequest request);
    public ProductResponse toProductResponse(Product product);
}
