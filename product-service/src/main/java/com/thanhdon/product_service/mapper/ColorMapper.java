package com.thanhdon.product_service.mapper;

import com.thanhdon.product_service.dto.request.ColorRequest;
import com.thanhdon.product_service.dto.request.SizeRequest;
import com.thanhdon.product_service.dto.response.ColorResponse;
import com.thanhdon.product_service.dto.response.SizeResponse;
import com.thanhdon.product_service.entity.ProductColor;
import com.thanhdon.product_service.entity.Size;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ColorMapper {
    ProductColor toProductColor(ColorRequest request);
    ColorResponse toColorResponse(ProductColor color);
}
