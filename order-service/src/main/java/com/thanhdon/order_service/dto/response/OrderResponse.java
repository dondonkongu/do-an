package com.thanhdon.order_service.dto.response;


import com.thanhdon.order_service.constant.Status;
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
    String userId;
    String phoneNumber;
    String note;
    String status;
    List<OrderItemResponse> items;
    Double totalPrice;
    String shippingAddress;

}

