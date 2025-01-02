package com.thanhdon.order_service.repository;

import com.thanhdon.order_service.dto.response.OrderResponse;
import com.thanhdon.order_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findOrdersByUserId(String userId);
}
