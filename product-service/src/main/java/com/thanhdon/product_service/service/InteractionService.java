package com.thanhdon.product_service.service;


import com.thanhdon.product_service.dto.request.InteractionRequest;
import com.thanhdon.product_service.entity.Interaction;
import com.thanhdon.product_service.mapper.InteractionMapper;
import com.thanhdon.product_service.repository.InteractionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Slf4j
public class InteractionService {
    InteractionMapper interactionMapper;
    InteractionRepository interactionRepository;
    int SPAM= 10;

    public String saveInteraction(InteractionRequest request){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime time = now.minusMinutes(SPAM);

        List<Interaction> recentInteraction = interactionRepository.findByUserIdAndProductIdAndInteractionTimeAfter(request.getUserId(), request.getProductId(), time);
        if(!recentInteraction.isEmpty()){
            return "Tương tác đã được ghi lại gần đây";
        }
        Interaction interaction = interactionMapper.toInteraction(request);
        interactionRepository.save(interaction);
        return "tuong tac da duoc luu";
    }
}
