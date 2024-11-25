package com.thanhdon.order_service.repository.httpclient;

import com.thanhdon.order_service.dto.request.ReduceStockRequest;
import com.thanhdon.order_service.dto.response.ProductVariantResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name ="product-service",url = "${app.service.product}")

public interface ProductClient {
    @GetMapping("/variants/{variantId}")
    ProductVariantResponse getProductVariantById(@PathVariable("variantId") Long variantId);

    @PostMapping("variants/reduce-stock")
    void reduceStock(@RequestBody ReduceStockRequest request);

}
