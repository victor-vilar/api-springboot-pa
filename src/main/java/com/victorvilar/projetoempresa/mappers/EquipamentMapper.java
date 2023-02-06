package com.victorvilar.projetoempresa.mappers;

import com.victorvilar.projetoempresa.controllers.dto.equipament.EquipamentResponseDto;
import com.victorvilar.projetoempresa.domain.Equipament;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EquipamentMapper {

    private final ModelMapper mapper;

    @Autowired
    public EquipamentMapper(ModelMapper map){
        this.mapper = map;
    }

    public EquipamentResponseDto toEquipamentResponseDto(Equipament equipament){
        return this.mapper.map(equipament,EquipamentResponseDto.class);
    }

    public List<EquipamentResponseDto> toEquipamentResponseDtoList(List<Equipament> list){
        return list.stream().map(e -> this.toEquipamentResponseDto(e)).collect(Collectors.toList());
    }
}
