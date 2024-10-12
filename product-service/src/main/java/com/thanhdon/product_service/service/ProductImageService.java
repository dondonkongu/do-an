package com.thanhdon.product_service.service;


import com.thanhdon.product_service.dto.request.ProductImageCreationRequest;
import com.thanhdon.product_service.dto.response.ProductImageResponse;
import com.thanhdon.product_service.entity.Product;
import com.thanhdon.product_service.entity.ProductImage;
import com.thanhdon.product_service.mapper.ProductImageMapper;
import com.thanhdon.product_service.mapper.ProductMapper;
import com.thanhdon.product_service.repository.ProductImageRepository;
import com.thanhdon.product_service.repository.ProductRepository;
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
public class ProductImageService {
    ProductImageMapper productImageMapper;
    ProductMapper productMapper;
    ProductService productService;
    ProductRepository productRepository;
    ProductImageRepository  productImageRepository;


    public ProductImageResponse createImage(ProductImageCreationRequest request){
        ProductImage productImage = productImageMapper.toProductImage(request);
        return productImageMapper.toProductImageResponse(productImageRepository.save(productImage));
    }

    // lay danh sach hinh anh cua mot product
    public List<ProductImageResponse> getImagesByProductId(Long productId){
        return productImageRepository.findProductImageByProductId(productId).stream().map(productImageMapper::toProductImageResponse).toList();
    }

    // them mot anh vao mot product

    public void addImageToProduct(Long productId, ProductImage productImage ) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("product not found"));
        productImage.setProduct(product);
        product.getProductImages().add(productImage);
        productRepository.save(product);
    }

    public void deleteProductImage(Long imageId){
        productImageRepository.deleteById(imageId);
    }

}
