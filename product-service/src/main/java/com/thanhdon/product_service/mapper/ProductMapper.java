package com.thanhdon.product_service.mapper;

import com.thanhdon.product_service.dto.request.ProductCreationRequest;
import com.thanhdon.product_service.dto.response.ProductResponse;
import com.thanhdon.product_service.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {ProductImageMapper.class})
public interface ProductMapper {
    @Mapping(target = "category", ignore = true)
    Product toProduct(ProductCreationRequest request);

    ProductResponse toProductResponse(Product product);
}
