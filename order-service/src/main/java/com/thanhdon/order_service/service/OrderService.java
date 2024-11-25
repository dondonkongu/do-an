package com.thanhdon.order_service.service;

import com.thanhdon.order_service.constant.Status;
import com.thanhdon.order_service.dto.request.OrderItemRequest;
import com.thanhdon.order_service.dto.request.OrderRequest;
import com.thanhdon.order_service.dto.request.ReduceStockRequest;
import com.thanhdon.order_service.dto.response.OrderResponse;
import com.thanhdon.order_service.dto.response.ProductVariantResponse;

import com.thanhdon.order_service.entity.Order;
import com.thanhdon.order_service.entity.OrderItem;
import com.thanhdon.order_service.mapper.OrderMapper;
import com.thanhdon.order_service.repository.OrderRepository;
import com.thanhdon.order_service.repository.httpclient.ProductClient;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderService {
    ProductClient productClient;
    OrderRepository orderRepository;
    OrderMapper orderMapper;

    public OrderResponse createOrder(OrderRequest request) {
        Order order = orderMapper.toOrder(request);
        order.setStatus(Status.PENDING);
        order.setOrderDate(LocalDateTime.now());

        double total = 0;

        List<OrderItem> orderItemList = new ArrayList<>();

        for (OrderItemRequest itemRequest  : request.getItems()){
            ProductVariantResponse productVariant = productClient.getProductVariantById(itemRequest.getVariantId());
            log.info("ProductVariant: {}", productVariant);

            if (productVariant.getStock()< itemRequest.getQuantity()){
                throw new IllegalArgumentException("Không đủ hàng cho sản phẩm");
            }

            OrderItem orderItem = new OrderItem();
            orderItem.setVariantId(productVariant.getId());
            orderItem.setPrice(productVariant.getPrice() * itemRequest.getQuantity());
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItem.setOrder(order);

            orderItemList.add(orderItem);
            total=+orderItem.getPrice();

        }
        order.setOrderItems(orderItemList);
        order.setTotalPrice(total);
        Order savedOrder = orderRepository.save(order);


        for (OrderItem item : savedOrder.getOrderItems()){

            productClient.reduceStock(new ReduceStockRequest(item.getVariantId(), item.getQuantity()));
        }

      return orderMapper.toOrderResponse(savedOrder);
    }



}
