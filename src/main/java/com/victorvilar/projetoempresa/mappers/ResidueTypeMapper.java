package com.victorvilar.projetoempresa.mappers;

import com.victorvilar.projetoempresa.controllers.dto.residuetype.ResidueTypeResponseDto;
import com.victorvilar.projetoempresa.domain.Residue;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResidueTypeMapper {


    private final ModelMapper mapper;

    @Autowired
    public ResidueTypeMapper(ModelMapper mapper){
        this.mapper = mapper;
    }

    public ResidueTypeResponseDto toResidueTypeResponseDto(Residue residue){
        return this.mapper.map(residue,ResidueTypeResponseDto.class);
    }

    public List<ResidueTypeResponseDto> toResidueTypeResponseDtoList(List<Residue> list){
        return list.stream().map(e -> this.toResidueTypeResponseDto(e)).collect(Collectors.toList());
    }

}
