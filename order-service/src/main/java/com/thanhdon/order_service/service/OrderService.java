package com.thanhdon.order_service.service;

import com.thanhdon.order_service.constant.Status;
import com.thanhdon.order_service.dto.ApiResponse;
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
        order.setStatus(Status.PENDING.getStatus());

        // Chuyển các items từ request sang entity Item
        List<Item> items = itemMapper.toItemList(request.getItems());
        items.forEach(item -> item.setOrder(order));  // Liên kết order với item

        // Gán items vào order trước khi tính toán tổng giá trị
        order.setItems(items);

        // Tính tổng giá trị của đơn hàng
        BigDecimal totalPrice = items.stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setTotalPrice(totalPrice.add(request.getShippingFee()));

        // Lưu đơn hàng vào cơ sở dữ liệu
        Orders savedOrder = orderRepository.save(order);

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

    public OrderResponse updateOrder(String orderId,String status){
        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);
        return orderMapper.toOrderResponse(order);
    }

    public List<OrderResponse> getAllOrdersByUserId(String userId) {
       return orderRepository.findAllByUserId(userId).stream().map(orderMapper::toOrderResponse).toList();

    }

}
