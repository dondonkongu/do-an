package com.thanhdon.product_service.mapper;


import com.thanhdon.product_service.dto.request.ProductImageCreationRequest;
import com.thanhdon.product_service.dto.response.ProductImageResponse;
import com.thanhdon.product_service.entity.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductImageMapper {
    @Mapping(target = "color", ignore = true)
    @Mapping(target = "imageUrl", ignore = true)

    public ProductImage toProductImage(ProductImageCreationRequest request);
    public ProductImageResponse toProductImageResponse(ProductImage productImage);
}
