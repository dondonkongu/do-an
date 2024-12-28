package com.thanhdon.product_service.controller;

import com.thanhdon.product_service.dto.request.InteractionRequest;
import com.thanhdon.product_service.dto.response.ApiResponse;
import com.thanhdon.product_service.service.InteractionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/interactions")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class InteractionController {
   InteractionService interactionService;

   @PostMapping
    ApiResponse<String> saveInteraction(@RequestBody InteractionRequest request){
       return ApiResponse.<String>builder()
               .message(interactionService.saveInteraction(request))
               .build();
   }



}
