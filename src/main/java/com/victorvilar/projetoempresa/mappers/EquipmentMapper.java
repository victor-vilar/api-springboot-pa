package com.victorvilar.projetoempresa.mappers;

import com.victorvilar.projetoempresa.controllers.dto.equipament.EquipmentResponseDto;
import com.victorvilar.projetoempresa.domain.Equipament;
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

    public EquipmentResponseDto toEquipamentResponseDto(Equipament equipament){
        return this.mapper.map(equipament, EquipmentResponseDto.class);
    }

    public List<EquipmentResponseDto> toEquipamentResponseDtoList(List<Equipament> list){
        return list.stream().map(e -> this.toEquipamentResponseDto(e)).collect(Collectors.toList());
    }
}
