package com.thanhdon.product_service.mapper;

import com.thanhdon.product_service.dto.request.ProductVariantRequest;
import com.thanhdon.product_service.dto.response.ProductVariantResponse;
import com.thanhdon.product_service.entity.ProductVariant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductVariantMapper {
    @Mapping( source = "productId",target = "product.id")
    ProductVariant toProductVariant(ProductVariantRequest request);

    @Mapping(source = "product.id", target = "productId")
    ProductVariantResponse toProductVariantResponse(ProductVariant productVariant);

    List<ProductVariantResponse> toVariantResponseList(List<ProductVariant> list);
}
