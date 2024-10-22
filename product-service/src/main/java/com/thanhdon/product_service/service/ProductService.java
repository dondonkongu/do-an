package com.thanhdon.product_service.service;


import com.thanhdon.product_service.dto.request.ProductCreationRequest;
import com.thanhdon.product_service.dto.request.ProductImageCreationRequest;
import com.thanhdon.product_service.dto.response.ProductResponse;
import com.thanhdon.product_service.entity.Product;
import com.thanhdon.product_service.entity.ProductColor;
import com.thanhdon.product_service.entity.ProductImage;
import com.thanhdon.product_service.mapper.ProductMapper;
import com.thanhdon.product_service.mapper.SizeMapper;
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
    SubcategoryRepository subcategoryRepository;
    SizeRepository sizeRepository;
    ColorRepository colorRepository;

    public ProductResponse createProduct(ProductCreationRequest request){
        Product product = productMapper.toProduct(request);
        if(productRepository.existsByName(product.getName())) throw new RuntimeException("product existed!!");


        var sizes = sizeRepository.findAllById(request.getSizes());
        product.setSizes(sizes);
        


        List<ProductImage> productImages = request.getProductImages().stream()
                .map(imgRequest -> {
                    // Tạo đối tượng ProductImage
                    ProductImage productImage = new ProductImage();

                    // Lấy ProductColor từ cơ sở dữ liệu

                    ProductColor color = colorRepository.findById(imgRequest.getColorName())
                            .orElseThrow(() -> new RuntimeException("Color not found"));
                    productImage.setColor(color); // Gán màu sắc

                    productImage.setImageUrl(imgRequest.getImageUrl());
                    productImage.setIsMain(imgRequest.getIsMain());
                    productImage.setProduct(product); // Thiết lập liên kết với sản phẩm
                    return productImage;
                })
                .collect(Collectors.toList());



        product.setProductImages(productImages);

        return productMapper.toProductResponse(productRepository.save(product));
    }
    public ProductResponse getProductById(Long id){
        return productMapper.toProductResponse(productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found !!")));
    }

    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll().stream().map(productMapper::toProductResponse).toList();
    }
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }



}
