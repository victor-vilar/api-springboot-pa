package com.victorvilar.projetoempresa.mappers;

import com.victorvilar.projetoempresa.controllers.dto.contract.ItemContractCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ItemContractResponseDto;
import com.victorvilar.projetoempresa.domain.ItemContract;
import com.victorvilar.projetoempresa.services.EquipamentService;
import com.victorvilar.projetoempresa.services.ResidueService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemContractMapper {

    private final ModelMapper mapper;
    private final ResidueService residueService;
    private final EquipamentService equipamentService;

    @Autowired
    public ItemContractMapper(ModelMapper mapper,
                              ResidueService residueService,
                              EquipamentService equipamentService){
        this.mapper = mapper;
        this.residueService=residueService;
        this.equipamentService=equipamentService;
    }

    public ItemContract toItemContract(ItemContractCreateDto itemDto){
        ItemContract item = this.toItemContract(itemDto);
        item.setResidue(this.residueService.findById(itemDto.getResidue()));
        item.setEquipament(this.equipamentService.findEquipamentById(itemDto.getEquipament()));
        return item;

    }

    public ItemContractResponseDto toItemContractResponseDto(ItemContract item){
        return this.mapper.map(item,ItemContractResponseDto.class);
    }


    //transform all itemContractCreateDto into a ItemContract List
    public List<ItemContract> toItemContractList(List<ItemContractCreateDto> list){
           return list.stream().map(
                    e -> {
                        return this.toItemContract(e);
                    }
            ).collect(Collectors.toList());

    }

}
