package com.victorvilar.projetoempresa.mappers;

import com.victorvilar.projetoempresa.controllers.dto.contract.ItemContractCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ItemContractResponseDto;
import com.victorvilar.projetoempresa.domain.ItemContract;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemContractMapper {

    private ModelMapper mapper;

    @Autowired
    public ItemContractMapper(ModelMapper mapper){
        this.mapper = mapper;
    }

    public ItemContract toItemContract(ItemContractCreateDto itemDto){
        return this.mapper.map(itemDto,ItemContract.class);
    }

    public ItemContractResponseDto toItemContractResponseDto(ItemContract item){
        return this.mapper.map(item,ItemContractResponseDto.class);
    }

}
