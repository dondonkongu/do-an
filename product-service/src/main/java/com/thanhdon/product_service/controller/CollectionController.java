package com.thanhdon.product_service.controller;


import com.thanhdon.product_service.dto.request.CollectionRequest;
import com.thanhdon.product_service.dto.response.ApiResponse;
import com.thanhdon.product_service.dto.response.CollectionResponse;
import com.thanhdon.product_service.service.CollectionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collections")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CollectionController {
    CollectionService collectionService;


    @PostMapping
    ApiResponse<CollectionResponse> create(@RequestBody CollectionRequest request){
        return ApiResponse.<CollectionResponse>builder()
                .result(collectionService.createCol(request))
                .build();
    }
    @GetMapping
    ApiResponse<List<CollectionResponse>> getAllCols(){
        return ApiResponse.<List<CollectionResponse>>builder()
                .result(collectionService.getAllCols())
                .build();
    }
    @GetMapping("/{colId}")
    ApiResponse<CollectionResponse> getCol(@PathVariable Long colId){
        return ApiResponse.<CollectionResponse>builder()
                .result(collectionService.getColById(colId))
                .build();
    }
    @DeleteMapping("/{colId}")
    ApiResponse<Void> deleteCol(@PathVariable Long colId){
            collectionService.deleteColById(colId);
        return ApiResponse.<Void>builder()
                .message("col has been deleted !!")
                .build();
    }

}
