package com.thanhdon.order_service.mapper;


import com.thanhdon.order_service.dto.request.ItemRequest;
import com.thanhdon.order_service.entity.Item;
import org.mapstruct.Mapper;
import java.util.List;


@Mapper(componentModel = "spring")
public interface ItemMapper {

        Item toItem(ItemRequest request);
        List<Item> toItemList(List<ItemRequest> itemRequests);


}
