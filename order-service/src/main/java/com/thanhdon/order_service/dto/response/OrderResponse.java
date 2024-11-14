package com.thanhdon.order_service.dto.response;

import com.thanhdon.order_service.entity.Item;
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
    String orderId;
    String userId;
    List<ItemResponse> items;
    BigDecimal shippingFee;
    String address;
    String paymentStatus;
    String paymentMethod;
}

