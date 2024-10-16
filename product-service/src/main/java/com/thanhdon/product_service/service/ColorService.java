package com.thanhdon.product_service.service;


import com.thanhdon.product_service.dto.request.ColorRequest;
import com.thanhdon.product_service.dto.response.ColorResponse;
import com.thanhdon.product_service.entity.ProductColor;
import com.thanhdon.product_service.mapper.ColorMapper;
import com.thanhdon.product_service.repository.ColorRepository;

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
public class ColorService {

    ColorMapper colorMapper;
    ColorRepository colorRepository;

    public ColorResponse create(ColorRequest request){

        ProductColor color = colorMapper.toProductColor(request);

        if(colorRepository.existsById(request.getName())) throw new RuntimeException("size existed!!");

        return colorMapper.toColorResponse(colorRepository.save(color));

    }

    public List<ColorResponse> getAll(){
        return colorRepository.findAll().stream().map(colorMapper::toColorResponse).toList();
    }

    public void deleteColor(String name){
        colorRepository.deleteById(name);
    }
}
