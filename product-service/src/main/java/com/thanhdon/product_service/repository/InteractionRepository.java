package com.thanhdon.product_service.repository;

import com.thanhdon.product_service.entity.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface InteractionRepository extends JpaRepository<Interaction,Long> {

    List<Interaction> findByUserIdAndProductIdAndInteractionTimeAfter(
            Long userId, Long productId, LocalDateTime interactionTime
    );
}
//SELECT *
//FROM interactions
//WHERE user_id = ? AND product_id = ? AND interaction_time > ?