package com.thanhdon.product_service.controller;

import com.thanhdon.product_service.dto.request.CategoryCreationRequest;
import com.thanhdon.product_service.dto.request.ProductCreationRequest;
import com.thanhdon.product_service.dto.response.ApiResponse;
import com.thanhdon.product_service.dto.response.CategoryResponse;
import com.thanhdon.product_service.dto.response.ProductResponse;
import com.thanhdon.product_service.service.CategoryService;
import com.thanhdon.product_service.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class ProductController {
    ProductService productService;

    @PostMapping()
    ApiResponse<ProductResponse> createProduct(@RequestBody ProductCreationRequest request){
        return ApiResponse.<ProductResponse>builder()
                .result(productService.createProduct(request))
                .build();
    }

    @GetMapping()
    ApiResponse<List<ProductResponse>> getAllProducts(){
        return ApiResponse.<List<ProductResponse>>builder()
                .result(productService.getAllProducts())
                .build();
    }
    @DeleteMapping("/{productId}")
    ApiResponse<Void> deleteCategory(@PathVariable("productId") Long productId){
        productService.deleteProductById(productId);
        return ApiResponse.<Void>builder()
                .message("delete product successfully !!")
                .build();
    }
    @GetMapping("/search")
    ApiResponse<List<ProductResponse>> search(@RequestParam String name){
        return ApiResponse.<List<ProductResponse>>builder()
                .result(productService.searchByName(name))
                .build();
    }
    @GetMapping("/filter")
    ApiResponse<List<ProductResponse>> filter(@RequestParam(required = false) List<String> color,
                                              @RequestParam(required = false) List<String> size){
        return ApiResponse.<List<ProductResponse>>builder()
                .result(productService.filter(color,size))
                .build();
    }
}
