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

    public String saveInteraction(InteractionRequest request){
        LocalDateTime now = LocalDateTime.now();


        List<Interaction> recentInteraction = interactionRepository.findByUserIdAndProductId(request.getUserId(), request.getProductId());
        if(!recentInteraction.isEmpty()){
            return "Tương tác đã được ghi lại ";
        }
        Interaction interaction = interactionMapper.toInteraction(request);
        interaction.setInteractionTime(now);
        interactionRepository.save(interaction);

        return "tuong tac da duoc luu";
    }
}
