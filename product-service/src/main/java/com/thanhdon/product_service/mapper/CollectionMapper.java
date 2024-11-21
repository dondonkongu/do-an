package com.thanhdon.product_service.mapper;


import com.thanhdon.product_service.dto.request.CollectionRequest;
import com.thanhdon.product_service.dto.response.CollectionResponse;
import com.thanhdon.product_service.entity.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CollectionMapper {
    @Mapping(target = "products", ignore = true)
    Collection toCollection(CollectionRequest request);

    CollectionResponse toCollectionResponse(Collection collection);
}
