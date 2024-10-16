package com.thanhdon.product_service.controller;

import com.thanhdon.product_service.dto.request.SizeRequest;
import com.thanhdon.product_service.dto.response.ApiResponse;
import com.thanhdon.product_service.dto.response.SizeResponse;
import com.thanhdon.product_service.service.SizeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sizes")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SizeController {

    SizeService sizeService ;

    @PostMapping
    ApiResponse<SizeResponse> create(@RequestBody SizeRequest request){
        return ApiResponse.<SizeResponse>builder()
                .result(sizeService.create(request))
                .build();

    }

    @GetMapping
    ApiResponse<List<SizeResponse>> getAll(){
        return ApiResponse.<List<SizeResponse>>builder()
                .result(sizeService.getAll())
                .build();
    }

    @DeleteMapping("/{nameSize}")
    ApiResponse<Void> delete(@PathVariable String nameSize){
        sizeService.deleteSize(nameSize);
        return ApiResponse.<Void>builder()
                .message("delete successfully")
                .build();
    }


}
