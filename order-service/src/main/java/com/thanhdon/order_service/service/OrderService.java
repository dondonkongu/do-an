package com.thanhdon.order_service.service;

import com.thanhdon.order_service.dto.request.OrderRequest;
import com.thanhdon.order_service.dto.response.OrderResponse;
import com.thanhdon.order_service.entity.Item;
import com.thanhdon.order_service.entity.Orders;
import com.thanhdon.order_service.mapper.ItemMapper;
import com.thanhdon.order_service.mapper.OrderMapper;
import com.thanhdon.order_service.repository.OrderRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderService {

    OrderRepository orderRepository;
    OrderMapper orderMapper;
    ItemMapper itemMapper;

    public OrderResponse createOrder(OrderRequest request) {
        Orders order = orderMapper.toOrder(request);

        // Gán trạng thái mặc định và tính toán giá trị tổng
        order.setStatus("Pending");
        List<Item> items = itemMapper.toItemList(request.getItems());
        BigDecimal totalPrice = order.getItems().stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setTotalPrice(totalPrice.add(request.getShippingFee()));

        Orders savedOrder = orderRepository.save(order);

        // Chuyển đổi đối tượng Orders thành OrderResponse và trả về
        return orderMapper.toOrderResponse(savedOrder);
    }

    public OrderResponse getOrderById(String orderId) {
        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return orderMapper.toOrderResponse(order);
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toOrderResponse)
                .collect(Collectors.toList());
    }
}
