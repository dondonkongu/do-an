package com.thanhdon.product_service.controller;

import com.thanhdon.product_service.dto.request.ColorRequest;
import com.thanhdon.product_service.dto.response.ApiResponse;
import com.thanhdon.product_service.dto.response.ColorResponse;
import com.thanhdon.product_service.service.ColorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/colors")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ColorController {

    ColorService colorService;

    @PostMapping
    ApiResponse<ColorResponse> create(@RequestBody ColorRequest request){
        return ApiResponse.<ColorResponse>builder()
                .result(colorService.create(request))
                .build();
    }
    @GetMapping
    ApiResponse<List<ColorResponse>> getAll(){
        return  ApiResponse.<List<ColorResponse>>builder()
                .result(colorService.getAll())
                .build();
    }

    @DeleteMapping("/{nameColor}")
    ApiResponse<Void> delete(@PathVariable String nameColor){
        colorService.deleteColor(nameColor);
        return ApiResponse.<Void>builder()
                .message("delete color successfully")
                .build();

    }
}
