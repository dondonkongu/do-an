package com.thanhdon.product_service.mapper;


import com.thanhdon.product_service.dto.request.CategoryCreationRequest;
import com.thanhdon.product_service.dto.response.CategoryResponse;
import com.thanhdon.product_service.entity.Category;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CategoryMapper {
    public Category toCategory(CategoryCreationRequest request);
    public CategoryResponse toCategoryResponse(Category category);

}
