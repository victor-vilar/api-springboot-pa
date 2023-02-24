package com.victorvilar.projetoempresa.mappers;

import com.victorvilar.projetoempresa.controllers.dto.equipament.EquipmentResponseDto;
import com.victorvilar.projetoempresa.domain.Equipment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EquipmentMapper {

    private final ModelMapper mapper;

    @Autowired
    public EquipmentMapper(ModelMapper map){
        this.mapper = map;
    }

    public EquipmentResponseDto toEquipmentResponseDto(Equipment equipment){
        return this.mapper.map(equipment, EquipmentResponseDto.class);
    }

    public List<EquipmentResponseDto> toEquipmentResponseDtoList(List<Equipment> list){
        return list.stream().map(e -> this.toEquipmentResponseDto(e)).collect(Collectors.toList());
    }
}
