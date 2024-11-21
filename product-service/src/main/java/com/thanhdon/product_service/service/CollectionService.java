package com.thanhdon.product_service.service;

import com.thanhdon.product_service.dto.request.CollectionRequest;
import com.thanhdon.product_service.dto.response.CollectionResponse;
import com.thanhdon.product_service.entity.Collection;
import com.thanhdon.product_service.entity.Product;
import com.thanhdon.product_service.mapper.CollectionMapper;
import com.thanhdon.product_service.repository.CollectionRepository;
import com.thanhdon.product_service.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)

public class CollectionService {

    CollectionMapper collectionMapper;
    CollectionRepository collectionRepository;
    ProductRepository productRepository;

    public CollectionResponse createCol(CollectionRequest request){
        Collection col = collectionMapper.toCollection(request);

        List<Product> products = productRepository.findAllById(request.getProductIds());

        col.setProducts(products);

        return collectionMapper.toCollectionResponse(collectionRepository.save(col));
    }

    public List<CollectionResponse> getAllCols(){
        return collectionRepository.findAll().stream().map(collectionMapper::toCollectionResponse).toList();
    }
    public CollectionResponse getColById(Long id){
        return collectionMapper.toCollectionResponse(collectionRepository.findById(id)
                .orElseThrow(()->new RuntimeException("collection not found"))
        );
    }
    public void deleteColById(Long id){
         collectionRepository.deleteById(id);
    }

}
