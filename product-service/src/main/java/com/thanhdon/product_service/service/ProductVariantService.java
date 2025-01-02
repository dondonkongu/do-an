package com.thanhdon.product_service.service;


import com.thanhdon.product_service.dto.request.ProductVariantRequest;
import com.thanhdon.product_service.dto.request.ReduceStockRequest;
import com.thanhdon.product_service.dto.response.ProductVariantResponse;
import com.thanhdon.product_service.entity.Product;
import com.thanhdon.product_service.entity.ProductVariant;
import com.thanhdon.product_service.exception.AppException;
import com.thanhdon.product_service.exception.ErrorCode;
import com.thanhdon.product_service.mapper.ProductVariantMapper;
import com.thanhdon.product_service.repository.ProductRepository;
import com.thanhdon.product_service.repository.ProductVariantRepository;
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
public class ProductVariantService {

    ProductVariantRepository productVariantRepository;
    ProductVariantMapper productVariantMapper;
    ProductRepository productRepository;

    public ProductVariantResponse create(ProductVariantRequest request){
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXISTED));

        ProductVariant productVariant = productVariantMapper.toProductVariant(request);
        productVariant.setProduct(product);
        return productVariantMapper.toProductVariantResponse(productVariantRepository.save(productVariant));
    }

    public List<ProductVariantResponse> getAll(){
        return productVariantMapper.toVariantResponseList(productVariantRepository.findAll());
    }


    public ProductVariantResponse update(Long id, ProductVariantRequest request){
        productRepository.findById(request.getProductId())
                .orElseThrow(()->new AppException(ErrorCode.PRODUCT_NOT_EXISTED));

        ProductVariant productVariant = productVariantRepository.findById(id)
                .orElseThrow(()->new AppException(ErrorCode.VARIANT_NOT_EXISTED));

        productVariant.setColor(request.getColor());
        productVariant.setSize(request.getSize());
        productVariant.setStock(request.getStock());

    return productVariantMapper.toProductVariantResponse(productVariantRepository.save(productVariant));
    }


    public List<ProductVariantResponse> getAllVariantByProductId(Long id){
        List<ProductVariant> variantList = productVariantRepository.findAllByProductId(id);
        return productVariantMapper.toVariantResponseList(variantList);
    }

    public ProductVariantResponse getProductVariantById(Long id) {
        ProductVariant variant = productVariantRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.VARIANT_NOT_EXISTED));
        return productVariantMapper.toProductVariantResponse(variant);
    }


    public void deleteProductVariant(Long id) {
        ProductVariant variant = productVariantRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.VARIANT_NOT_EXISTED));
        productVariantRepository.delete(variant);
    }

    public void reduceStock(ReduceStockRequest request){
        ProductVariant variant = productVariantRepository.findById(request.getProductVariantId())
                .orElseThrow(() -> new AppException(ErrorCode.VARIANT_NOT_EXISTED));
        variant.setStock(variant.getStock()- request.getQuantity());
        productVariantRepository.save(variant);
        System.out.print("da reduce");
    }




}
