package com.thanhdon.product_service.service;


import com.thanhdon.product_service.dto.request.ProductCreationRequest;
import com.thanhdon.product_service.dto.response.ProductResponse;
import com.thanhdon.product_service.entity.Product;
import com.thanhdon.product_service.entity.ProductImage;
import com.thanhdon.product_service.mapper.ProductMapper;
import com.thanhdon.product_service.repository.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Slf4j
public class ProductService {
    CategoryRepository categoryRepository;
    ProductRepository productRepository;
    ProductMapper productMapper;


    public ProductResponse createProduct(ProductCreationRequest request){
        Product product = productMapper.toProduct(request);
        var category = categoryRepository.findById(request.getCategoryId()).orElseThrow(()->new RuntimeException("category not found"));
        product.setCategory(category);
        if(productRepository.existsByName(product.getName())) throw new RuntimeException("product existed!!");
        return productMapper.toProductResponse(productRepository.save(product));
    }
    
    public ProductResponse getProductById(Long id){
        return productMapper.toProductResponse(productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found !!")));
    }

    public ProductResponse updateProductById(Long id){
            Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found"));

            return productMapper.toProductResponse(product);
    }

    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll().stream().map(productMapper::toProductResponse).toList();
    }
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }



}
