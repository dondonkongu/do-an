package com.thanhdon.order_service.mapper;

import com.thanhdon.order_service.dto.request.OrderRequest;
import com.thanhdon.order_service.dto.response.OrderItemResponse;
import com.thanhdon.order_service.dto.response.OrderResponse;
import com.thanhdon.order_service.entity.Order;
import com.thanhdon.order_service.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    // Ánh xạ Order sang OrderResponse, ánh xạ orderItems => items (OrderItemResponse)
    @Mapping(source = "orderItems", target = "items")
    @Mapping(source = "id", target = "orderId")
    OrderResponse toOrderResponse(Order order);

    // Ánh xạ OrderItem sang OrderItemResponse
    OrderItemResponse toOrderItemResponse(OrderItem orderItem);

    // Ánh xạ từ OrderRequest sang Order, bỏ qua các trường sẽ được gán trong service

    @Mapping(target = "orderDate", ignore = true)
    @Mapping(target = "orderItems", ignore = true)

    Order toOrder(OrderRequest orderRequest);
}

