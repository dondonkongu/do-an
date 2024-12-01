package com.thanhdon.product_service.service;

import com.thanhdon.product_service.dto.request.CategoryCreationRequest;
import com.thanhdon.product_service.dto.request.SubCategoryCreationRequest;
import com.thanhdon.product_service.dto.response.SubCategoryResponse;
import com.thanhdon.product_service.entity.SubCategory;
import com.thanhdon.product_service.exception.AppException;
import com.thanhdon.product_service.exception.ErrorCode;
import com.thanhdon.product_service.mapper.SubCategoryMapper;
import com.thanhdon.product_service.repository.SubCategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Slf4j
public class SubCategoryService {
    SubCategoryRepository subCategoryRepository;
    SubCategoryMapper subCategoryMapper;

    public SubCategoryResponse createSubCategory(SubCategoryCreationRequest request){
        SubCategory subCategory = subCategoryMapper.toSubCategory(request);
        if(subCategoryRepository.existsByName(request.getName()))
            throw new AppException(ErrorCode.SUB_CATEGORY_NOT_EXISTED);
        return subCategoryMapper.toSubCategoryResponse(subCategoryRepository.save(subCategory));
    }

    public List<SubCategoryResponse> getAllSubCategories(){
        return subCategoryRepository.findAll().stream()
                .map(subCategoryMapper::toSubCategoryResponse).toList();
    }

    public SubCategoryResponse getSubCategoryById(Long id){
         return  subCategoryMapper.toSubCategoryResponse(subCategoryRepository.findById(id)
                .orElseThrow(()->new AppException(ErrorCode.SUB_CATEGORY_NOT_EXISTED)));
    }
    public void deleteSubCategory(Long id){
       subCategoryRepository.deleteById(id);
    }

    public SubCategoryResponse updateSubCategory(Long id, SubCategoryCreationRequest request) {
       SubCategory subCategory = subCategoryRepository.findById(id).orElseThrow(()->new AppException(ErrorCode.SUB_CATEGORY_NOT_EXISTED));
        subCategory.setName(request.getName());
        subCategory.setDescription(request.getDescription());
        return subCategoryMapper.toSubCategoryResponse(subCategoryRepository.save(subCategory));
    }
}
