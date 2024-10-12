package com.thanhdon.product_service.controller;

import com.thanhdon.product_service.dto.request.CategoryCreationRequest;
import com.thanhdon.product_service.dto.request.SubcategoryCreationRequest;
import com.thanhdon.product_service.dto.response.ApiResponse;
import com.thanhdon.product_service.dto.response.CategoryResponse;
import com.thanhdon.product_service.dto.response.SubcategoryResponse;
import com.thanhdon.product_service.service.CategoryService;
import com.thanhdon.product_service.service.SubCategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/subcategories")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class SubcategoryController {
    SubCategoryService subCategoryService;

    @PostMapping()
    ApiResponse<SubcategoryResponse> createCategory(@RequestBody SubcategoryCreationRequest request){
        return ApiResponse.<SubcategoryResponse>builder()
                .result(subCategoryService.create(request))
                .build();
    }

    @GetMapping()
    ApiResponse<List<SubcategoryResponse>> getAllSubcategories(){
        return ApiResponse.<List<SubcategoryResponse>>builder()
                .result(subCategoryService.getAll())
                .build();
    }
    @DeleteMapping("/{subcategoryId}")
    ApiResponse<Void> deleteSubcategory(@PathVariable("subcategoryId") Long categoryId){
        subCategoryService.deleteSubcategory(categoryId);
        return ApiResponse.<Void>builder()
                .message("delete category successfully !!")
                .build();
    }

}
