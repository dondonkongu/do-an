package com.thanhdon.product_service.mapper;


import com.thanhdon.product_service.dto.request.CategoryCreationRequest;
import com.thanhdon.product_service.dto.request.CategoryUpdateRequest;
import com.thanhdon.product_service.dto.response.CategoryResponse;
import com.thanhdon.product_service.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "subcategories", ignore = true)
    public Category toCategory(CategoryCreationRequest request);
    public CategoryResponse toCategoryResponse(Category category);
    @Mapping(target = "subcategories", ignore = true)
    public void updateCategory(@MappingTarget Category category, CategoryUpdateRequest request);
}
