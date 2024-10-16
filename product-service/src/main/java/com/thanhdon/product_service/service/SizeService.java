package com.thanhdon.product_service.service;

import com.thanhdon.product_service.dto.request.SizeRequest;
import com.thanhdon.product_service.dto.response.SizeResponse;
import com.thanhdon.product_service.entity.Size;
import com.thanhdon.product_service.mapper.SizeMapper;
import com.thanhdon.product_service.repository.SizeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Slf4j
public class SizeService {

    SizeMapper sizeMapper;
    SizeRepository sizeRepository;

    public SizeResponse create(SizeRequest request){

        Size size = sizeMapper.toSize(request);

        if(sizeRepository.existsById(request.getName())) throw new RuntimeException("size existed!!");

        return sizeMapper.toSizeResponse(sizeRepository.save(size));

    }

    public List<SizeResponse> getAll(){
        return sizeRepository.findAll().stream().map(sizeMapper::toSizeResponse).toList();
    }

    public void deleteSize(String name){
         sizeRepository.deleteById(name);
    }
}
