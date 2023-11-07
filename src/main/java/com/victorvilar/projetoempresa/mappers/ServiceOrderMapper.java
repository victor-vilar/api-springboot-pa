package com.victorvilar.projetoempresa.mappers;

import com.victorvilar.projetoempresa.domain.ServiceOrder;
import com.victorvilar.projetoempresa.dto.serviceorder.ServiceOrderCreateDto;
import com.victorvilar.projetoempresa.dto.serviceorder.ServiceOrderResponseDto;
import com.victorvilar.projetoempresa.dto.serviceorder.ServiceOrderUpdateDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceOrderMapper {

    private final ModelMapper mapper;

    @Autowired
    public ServiceOrderMapper(ModelMapper mapper){
        this.mapper = mapper;
    }

    public ServiceOrder toServiceOrder(ServiceOrderCreateDto createDto){
        return this.mapper.map(createDto,ServiceOrder.class);
    }

    public ServiceOrder toServiceOrder(ServiceOrderUpdateDto updateDto){
        return this.mapper.map(updateDto,ServiceOrder.class);
    }

    public ServiceOrderResponseDto toServiceOrderResponseDto(ServiceOrder order){
        return this.mapper.map(order,ServiceOrderResponseDto.class);
    }

    public List<ServiceOrderResponseDto> toServiceResponseDtoList(List<ServiceOrder> list ){
        return list.stream().map(order -> this.toServiceOrderResponseDto(order)).toList();
    }





}
