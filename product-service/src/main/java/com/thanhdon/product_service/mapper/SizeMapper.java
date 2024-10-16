package com.thanhdon.product_service.mapper;

import com.thanhdon.product_service.dto.request.SizeRequest;
import com.thanhdon.product_service.dto.response.SizeResponse;
import com.thanhdon.product_service.entity.Size;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SizeMapper {

    Size toSize(SizeRequest request);
    SizeResponse toSizeResponse(Size size);
}
