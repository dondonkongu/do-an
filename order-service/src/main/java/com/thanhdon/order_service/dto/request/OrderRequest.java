package com.thanhdon.order_service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {
    String userId;
    Double totalPrice;
    List<OrderItemRequest> items;
    String phoneNumber;
    String shippingAddress;
    String note;

}
