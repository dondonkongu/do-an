package com.thanhdon.product_service.controller;


import com.thanhdon.product_service.dto.request.ImageUploadRequest;
import com.thanhdon.product_service.dto.response.ApiResponse;
import com.thanhdon.product_service.service.CloudinaryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ImageUploadController {

    CloudinaryService cloudinaryService;

    @PostMapping("/upload")
    ApiResponse<String> uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
        return  ApiResponse.<String>builder()
                .result(cloudinaryService.uploadImage(file))
                .build();
    }
}
