package com.thanhdon.product_service.service;


import com.thanhdon.product_service.dto.PageResponse;
import com.thanhdon.product_service.dto.request.ProductCreationRequest;
import com.thanhdon.product_service.dto.response.ProductResponse;
import com.thanhdon.product_service.entity.Product;
import com.thanhdon.product_service.entity.ProductImage;
import com.thanhdon.product_service.entity.Size;
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

import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Slf4j
public class ProductService {
    CategoryRepository categoryRepository;
    ProductRepository productRepository;
    ProductMapper productMapper;
    ProductImageMapper productImageMapper;
    ProductImageRepository productImageRepository;


    public ProductResponse createProduct(ProductCreationRequest request) {
        // Ánh xạ product từ DTO
        Product product = productMapper.toProduct(request);

        if (productRepository.existsByName(product.getName())) {
            throw new AppException(ErrorCode.PRODUCT_EXISTED);
        }

        var category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);

        if (product.getImages() != null) {
            for (ProductImage image : product.getImages()) {
                image.setProduct(product);
                if(image.getSizes() != null){
                    for(Size size: image.getSizes()){
                        size.setProductImage(image);
                    }
                }
            }
        }
        return productMapper.toProductResponse(productRepository.save(product));
    }

    public ProductResponse getProductById(Long id){
        return productMapper.toProductResponse(productRepository.findById(id).orElseThrow(()->new AppException(ErrorCode.PRODUCT_NOT_EXISTED)));
    }

    public ProductResponse updateProductById(Long id, ProductCreationRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(request.getName());
        product.setCode(request.getCode());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setMaterial(request.getMaterial());
        product.setOrigin(request.getOrigin());
        product.setDiscount(request.getDiscount());

        var category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);

        return productMapper.toProductResponse(productRepository.save(product));
    }

    public PageResponse<ProductResponse> getAllProducts(int page, int size){

        Sort sort = Sort.by("createdDate").descending();

        Pageable pageable = PageRequest.of(page-1,size, sort);



        return null;



//        return productRepository.findAll().stream().map(productMapper::toProductResponse).toList();
    }
    public void deleteProductById(Long id){
        if(!productRepository.existsById(id)) throw new RuntimeException("product not found");
        productRepository.deleteById(id);
    }

    public List<ProductResponse> searchByName(String name){
        return productRepository.findByNameLike(name).stream()
                .map(productMapper::toProductResponse)
                .toList();

    }
    public List<ProductResponse> filter(List<String> color, List<String> size) {
        return productRepository.findByColorAndSize(color, size).stream()
                .map(productMapper::toProductResponse)
                .toList();
    }

}
