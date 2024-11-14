package com.thanhdon.order_service.dto.request;

import com.thanhdon.order_service.entity.Item;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {
    String userId;
    List<ItemRequest> items;
    BigDecimal shippingFee;
    String address;
    String paymentStatus;
    String paymentMethod;

}
