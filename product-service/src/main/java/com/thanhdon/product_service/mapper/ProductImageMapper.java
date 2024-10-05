package com.thanhdon.product_service.mapper;


import com.thanhdon.product_service.dto.request.ProductImageCreationRequest;
import com.thanhdon.product_service.dto.response.ProductImageResponse;
import com.thanhdon.product_service.entity.ProductImage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductImageMapper {
    public ProductImage toProductImage(ProductImageCreationRequest request);
    public ProductImageResponse toProductImageResponse(ProductImage productImage);
}
