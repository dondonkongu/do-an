package com.thanhdon.order_service.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {
    Long orderId;
    Long userId;
    List<OrderItemResponse> items;
    Double totalPrice;
    String shippingAddress;

}

