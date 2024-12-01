package com.thanhdon.product_service.mapper;


import com.thanhdon.product_service.dto.request.SubCategoryCreationRequest;
import com.thanhdon.product_service.dto.response.SubCategoryResponse;
import com.thanhdon.product_service.entity.SubCategory;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface SubCategoryMapper {
     SubCategory toSubCategory(SubCategoryCreationRequest request);
     SubCategoryResponse toSubCategoryResponse(SubCategory category);

}
