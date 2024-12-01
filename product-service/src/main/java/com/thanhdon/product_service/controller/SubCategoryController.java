package com.thanhdon.product_service.controller;

import com.thanhdon.product_service.dto.request.SubCategoryCreationRequest;
import com.thanhdon.product_service.dto.response.ApiResponse;
import com.thanhdon.product_service.dto.response.CategoryResponse;
import com.thanhdon.product_service.dto.response.SubCategoryResponse;
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

public class SubCategoryController {
    SubCategoryService subCategoryService;

    @PostMapping()
    ApiResponse<SubCategoryResponse> createSubCategory(@RequestBody SubCategoryCreationRequest request){
        return ApiResponse.<SubCategoryResponse>builder()
                .result(subCategoryService.createSubCategory(request))
                .build();
    }

    @GetMapping()
    ApiResponse<List<SubCategoryResponse>> getAllCategories(){
        return ApiResponse.<List<SubCategoryResponse>>builder()
                .result(subCategoryService.getAllSubCategories())
                .build();
    }

    @GetMapping("/{subcategoryId}")
    ApiResponse<SubCategoryResponse> getCategoryById(@PathVariable Long subcategoryId){
        return ApiResponse.<SubCategoryResponse>builder()
                .result(subCategoryService.getSubCategoryById(subcategoryId))
                .build();
    }

    @PutMapping("/{subcategoryId}")
    ApiResponse<SubCategoryResponse> updateCategory(@PathVariable Long subcategoryId,@RequestBody SubCategoryCreationRequest request){
        return ApiResponse.<SubCategoryResponse>builder()
                .result(subCategoryService.updateSubCategory(subcategoryId,request))
                .build();
    }
    @DeleteMapping("/{subcategoryId}")
    ApiResponse<Void> deleteSubCategory(@PathVariable("subcategoryId") Long subcategoryId){
        subCategoryService.deleteSubCategory(subcategoryId);
        return ApiResponse.<Void>builder()
                .message("delete sub category successfully !!")
                .build();
    }



}
