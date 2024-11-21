package com.thanhdon.order_service.controller;


import com.thanhdon.order_service.dto.ApiResponse;
import com.thanhdon.order_service.dto.request.OrderRequest;
import com.thanhdon.order_service.dto.response.OrderResponse;
import com.thanhdon.order_service.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class OrderController {
    OrderService orderService;

    @PostMapping("/create")
    ApiResponse<OrderResponse> create(@RequestBody OrderRequest request){
        return ApiResponse.<OrderResponse>builder()
                .result(orderService.createOrder(request))
                .build();
    }
    @GetMapping()
    ApiResponse<List<OrderResponse>> getAllOrder(){
        return ApiResponse.<List<OrderResponse>>builder()
                .result(orderService.getAllOrders())
                .build();
    }
    @GetMapping("/{orderId}")
    ApiResponse<OrderResponse> getOrderById(@PathVariable String orderId){
        return ApiResponse.<OrderResponse>builder()
                .result(orderService.getOrderById(orderId))
                .build();
    }
    @GetMapping("/user/{userId}")
    ApiResponse<List<OrderResponse>> getAllOrder(@PathVariable String userId){
        return ApiResponse.<List<OrderResponse>>builder()
                .result(orderService.getAllOrdersByUserId(userId))
                .build();
    }


    @DeleteMapping("/{orderId}")
    ApiResponse<Void> deleteByOrderId(@PathVariable String orderId){
        return ApiResponse.<Void>builder()
                .message("order has been deleted!")
                .build();
    }
    @PutMapping("/{orderId}")
    ApiResponse<OrderResponse> updateOrderById(@PathVariable String orderId, @RequestBody String status){
        return ApiResponse.<OrderResponse>builder()
                .result(orderService.updateOrder(orderId,status))
                .build();
    }


}
