package com.thanhdon.product_service.mapper;

import com.thanhdon.product_service.dto.request.SubcategoryCreationRequest;
import com.thanhdon.product_service.dto.response.SubcategoryResponse;
import com.thanhdon.product_service.entity.Subcategory;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface SubcategoryMapper {
    public Subcategory toSubcategory(SubcategoryCreationRequest request);
    public SubcategoryResponse toSubcategoryResponse(Subcategory subcategory);
}
