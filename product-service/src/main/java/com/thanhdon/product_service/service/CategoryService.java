package com.thanhdon.product_service.service;

import com.thanhdon.product_service.dto.request.CategoryCreationRequest;

import com.thanhdon.product_service.dto.response.CategoryResponse;
import com.thanhdon.product_service.entity.Category;
import com.thanhdon.product_service.mapper.CategoryMapper;
import com.thanhdon.product_service.repository.CategoryRepository;

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
public class CategoryService {
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    public CategoryResponse createCategory(CategoryCreationRequest request){
        Category category = categoryMapper.toCategory(request);
        if(categoryRepository.existsByName(category.getName())) throw new RuntimeException("category existed");
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    public List<CategoryResponse> getAllCategories(){
        return categoryRepository.findAll().stream().map(categoryMapper::toCategoryResponse).toList();
    }

    public CategoryResponse getCategoryById(Long id){
         return categoryMapper.toCategoryResponse(categoryRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("Category not found")));
    }
    public void deleteCategory(Long id){
       categoryRepository.deleteById(id);
    }

    public CategoryResponse updateCategory(Long id, CategoryCreationRequest request) {
       Category category = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("category not found"));
        category.setName(request.getName());
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }
}
