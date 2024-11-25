package com.thanhdon.product_service.controller;


import com.thanhdon.product_service.dto.request.ProductVariantRequest;
import com.thanhdon.product_service.dto.request.ReduceStockRequest;
import com.thanhdon.product_service.dto.response.ApiResponse;
import com.thanhdon.product_service.dto.response.ProductVariantResponse;
import com.thanhdon.product_service.service.ProductVariantService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/variants")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class ProductVariantController {
    ProductVariantService productVariantService;


    @PostMapping
    ApiResponse<ProductVariantResponse> create(@RequestBody ProductVariantRequest request){
        return ApiResponse.<ProductVariantResponse>builder()
                .result(productVariantService.create(request))
                .build();
    }

    @PutMapping("/{id}")
    ApiResponse<ProductVariantResponse> updateVariant(@PathVariable Long id, @RequestBody ProductVariantRequest request) {
        return ApiResponse.<ProductVariantResponse>builder()
                .result(productVariantService.update(id, request))
                .build();
    }

    @GetMapping("/{id}")
    ProductVariantResponse getVariantById(@PathVariable Long id) {
        return productVariantService.getProductVariantById(id);
    }

    @GetMapping("/product/{productId}")
    ApiResponse<List<ProductVariantResponse>> getVariantsByProductId(@PathVariable Long productId) {
        return ApiResponse.<List<ProductVariantResponse>>builder()
                .result(productVariantService.getAllVariantByProductId(productId))
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteVariant(@PathVariable Long id) {
        productVariantService.deleteProductVariant(id);
        return ApiResponse.<Void>builder()
                .message("variant has been deleted!!")
                .build();
    }
    @PostMapping("/reduce-stock")
    ApiResponse<Void> reduceStock(@RequestBody ReduceStockRequest request){
        productVariantService.reduceStock(request);
        return ApiResponse.<Void>builder()
                .message("reduce stock successfully !!")
                .build();
    }



}
