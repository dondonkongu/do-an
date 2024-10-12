package com.thanhdon.product_service.service;


import com.thanhdon.product_service.dto.request.SubcategoryCreationRequest;
import com.thanhdon.product_service.dto.response.SubcategoryResponse;
import com.thanhdon.product_service.entity.Subcategory;
import com.thanhdon.product_service.mapper.SubcategoryMapper;
import com.thanhdon.product_service.repository.SubcategoryRepository;
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

    SubcategoryRepository subcategoryRepository;
    SubcategoryMapper subcategoryMapper;

    public SubcategoryResponse create(SubcategoryCreationRequest request){
        Subcategory subcategory = subcategoryMapper.toSubcategory(request);
        return subcategoryMapper.toSubcategoryResponse(subcategoryRepository.save(subcategory));
    }
    public List<SubcategoryResponse> getAll(){
        return subcategoryRepository.findAll().stream().map(subcategoryMapper::toSubcategoryResponse).toList();
    }
    public void deleteSubcategory(Long id){
        subcategoryRepository.deleteById(id);
    }

}
