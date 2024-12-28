package com.thanhdon.product_service.mapper;


import com.thanhdon.product_service.dto.request.InteractionRequest;
import com.thanhdon.product_service.entity.Interaction;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface InteractionMapper {
    public Interaction toInteraction(InteractionRequest request);

}
