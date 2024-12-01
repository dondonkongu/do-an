package com.thanhdon.product_service.service;


import com.thanhdon.product_service.dto.PageResponse;
import com.thanhdon.product_service.dto.request.ProductCreationRequest;
import com.thanhdon.product_service.dto.request.ProductImageCreationRequest;
import com.thanhdon.product_service.dto.request.ProductUpdateRequest;
import com.thanhdon.product_service.dto.response.ProductResponse;
import com.thanhdon.product_service.entity.Product;
import com.thanhdon.product_service.entity.ProductImage;

import com.thanhdon.product_service.exception.AppException;
import com.thanhdon.product_service.exception.ErrorCode;
import com.thanhdon.product_service.mapper.ProductImageMapper;
import com.thanhdon.product_service.mapper.ProductMapper;
import com.thanhdon.product_service.repository.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Slf4j
public class ProductService {
    CategoryRepository categoryRepository;
    ProductRepository productRepository;
    ProductMapper productMapper;


    public ProductResponse createProduct(ProductCreationRequest request) {
        Product product = productMapper.toProduct(request);

        if (productRepository.existsByName(product.getName())) {
            throw new AppException(ErrorCode.PRODUCT_EXISTED);
        }
        var category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_EXISTED));
        product.setCategory(category);

        List<ProductImage> productImages = new ArrayList<>();
        for (ProductImageCreationRequest imageRequest : request.getImages()) {
            ProductImage image = new ProductImage();
            image.setUrl(imageRequest.getUrl());
            image.setIsMain(imageRequest.getIsMain());
            image.setProduct(product);
            productImages.add(image);
        }
        product.setImages(productImages);
        product.setCreatedDate(Instant.now());
        product.setUpdatedDate(Instant.now());

        return productMapper.toProductResponse(productRepository.save(product));
    }

    public PageResponse<ProductResponse> getAll(int page, int size){
        log.info("Page requested: {}, Page size: {}", page, size);
        Pageable pageable = PageRequest.of(page-1, size);
        var pageData = productRepository.findAll(pageable);
        return PageResponse.<ProductResponse>builder()
                .currentPage(page)
                .pageSizes(pageData.getSize())
                .totalPages(pageData.getTotalPages())
                .totalElements(pageData.getTotalElements())
                .data(pageData.getContent().stream().map(productMapper::toProductResponse).toList())
                .build();
    }


    public PageResponse<ProductResponse> getProducts(int page, int size, String sortField) {
        Sort sort = (sortField != null && !sortField.isEmpty())
                ? Sort.by(sortField).descending()
                : Sort.unsorted();
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        var pageData = productRepository.findAll(pageable);
        return PageResponse.<ProductResponse>builder()
                .currentPage(page)
                .pageSizes(pageData.getSize())
                .totalPages(pageData.getTotalPages())
                .totalElements(pageData.getTotalElements())
                .data(pageData.getContent().stream().map(productMapper::toProductResponse).toList())
                .build();
    }


    public ProductResponse getProductById(Long id){
        return productMapper.toProductResponse(productRepository.findById(id).orElseThrow(()->new AppException(ErrorCode.PRODUCT_NOT_EXISTED)));
    }

    public ProductResponse updateProductById(Long id, ProductUpdateRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXISTED));
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        var category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_EXISTED));
        product.setCategory(category);
        product.setPrice(request.getPrice());

        return productMapper.toProductResponse(productRepository.save(product));
    }

    public void deleteProductById(Long id){
        if(!productRepository.existsById(id)) throw new AppException(ErrorCode.PRODUCT_NOT_EXISTED);
        productRepository.deleteById(id);
    }

    public List<ProductResponse> searchByName(String name){
        return productRepository.findByNameLike(name).stream()
                .map(productMapper::toProductResponse)
                .toList();
    }

    public List<ProductResponse> filter(List<Long> categoryId, List<Long> subcategoryId, List<String> color, List<String> size){
        var productLists = productRepository.findProductByVariantAttributes(categoryId,subcategoryId,color,size);
        return productMapper.toProductResponseList(productLists);
    }
    public List<ProductResponse> getProductBySubCategory(Long id){
         var products = productRepository.findBySubCategoryId(id);
         return productMapper.toProductResponseList(products);
    }



}
