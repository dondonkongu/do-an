package com.thanhdon.order_service.repository;

import com.thanhdon.order_service.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,String> {
        List<Orders> findAllByUserId(String userId);
}
