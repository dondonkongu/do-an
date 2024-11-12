package com.thanhdon.product_service.controller;


import com.thanhdon.product_service.dto.response.ApiResponse;
import com.thanhdon.product_service.dto.response.ProductImageResponse;
import com.thanhdon.product_service.entity.ProductImage;
import com.thanhdon.product_service.service.ProductImageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductImageController {
    ProductImageService productImageService;

    @GetMapping("/{productId}")
    ApiResponse<List<ProductImageResponse>> getImagesByProductId(@PathVariable("productId") Long productId){
        return ApiResponse.<List<ProductImageResponse>>builder()
                .result(productImageService.getImagesByProductId(productId))
                .build();
    }
//    @PostMapping("/{productId}")
//    ApiResponse<Void> addImagesToProduct(@PathVariable("productId") Long productId, ProductImage productImage){
//        productImageService.addImageToProduct(productId,productImage);
//        return ApiResponse.<Void>builder()
//                .message("add image to product successfully!!")
//                .build();
//    }

    @DeleteMapping("/{imageId}")
    ApiResponse<Void> deleteImageProduct(@PathVariable("imageId") Long imageId){
        productImageService.deleteProductImage(imageId);
        return ApiResponse.<Void>builder()
                .message("image have been delete!!!")
                .build();
    }

}
