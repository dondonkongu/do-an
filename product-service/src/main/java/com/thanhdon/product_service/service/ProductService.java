package com.thanhdon.product_service.service;


import com.thanhdon.product_service.dto.request.ProductCreationRequest;
import com.thanhdon.product_service.dto.response.ProductResponse;
import com.thanhdon.product_service.entity.Product;
import com.thanhdon.product_service.entity.ProductImage;
import com.thanhdon.product_service.entity.Size;
import com.thanhdon.product_service.mapper.ProductImageMapper;
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
    ProductImageMapper productImageMapper;
    ProductImageRepository productImageRepository;


    public ProductResponse createProduct(ProductCreationRequest request) {
        // Ánh xạ product từ DTO
        Product product = productMapper.toProduct(request);

        if (productRepository.existsByName(product.getName())) {
            throw new RuntimeException("Product already exists!");
        }

        var category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);

        // Gán `Product` cho mỗi `ProductImage`
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
        return productMapper.toProductResponse(productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found !!")));
    }

    public ProductResponse updateProductById(Long id,ProductCreationRequest request){
            Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found"));
            product.setName(request.getName());
            product.setPrice(request.getPrice());
            return productMapper.toProductResponse(productRepository.save(product));
    }

    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll().stream().map(productMapper::toProductResponse).toList();
    }
    public void deleteProductById(Long id){
        if(!productRepository.existsById(id)) throw new RuntimeException("product not found");
        productRepository.deleteById(id);
    }


}
