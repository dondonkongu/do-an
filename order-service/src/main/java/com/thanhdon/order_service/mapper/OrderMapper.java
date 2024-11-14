package com.thanhdon.order_service.mapper;


import com.thanhdon.order_service.dto.request.OrderRequest;
import com.thanhdon.order_service.dto.response.OrderResponse;
import com.thanhdon.order_service.entity.Orders;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface OrderMapper {
//    @Mapping(target = "items", ignore = true)
        Orders toOrder(OrderRequest request);
        OrderResponse toOrderResponse(Orders order);
}
