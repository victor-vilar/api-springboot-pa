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
        return null;
    }

    public ServiceOrder toServiceOrder(ServiceOrderUpdateDto updateDto){
        return null;
    }

    public ServiceOrderResponseDto toServiceOrderResponseDto(ServiceOrder order){
        return null;
    }

    public List<ServiceOrderResponseDto> toServiceResponseDtoList(List<ServiceOrder> list ){
        return null;
    }





}
