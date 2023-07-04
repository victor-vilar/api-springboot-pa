package com.victorvilar.projetoempresa.mappers;

import com.victorvilar.projetoempresa.controllers.dto.contract.ContractCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ContractResponseDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ContractUpdateDto;
import com.victorvilar.projetoempresa.domain.customer.Contract;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContractMapper {


    private final ModelMapper mapper;

    @Autowired
    public ContractMapper(ModelMapper mapper){
        this.mapper = mapper;
    }


    public Contract toContract(ContractCreateDto contractCreateDto){
        return this.mapper.map(contractCreateDto, Contract.class);
    }

    public Contract toContract(ContractUpdateDto contractUpdateDto){
        return this.mapper.map(contractUpdateDto,Contract.class);
    }

    public ContractResponseDto toContractResponseDto(Contract contract){
        return this.mapper.map(contract,ContractResponseDto.class);
    }

    public List<ContractResponseDto> toContractResponsDtoList(List<Contract> contracts){
        return contracts.stream().map(c ->this.toContractResponseDto(c)).collect(Collectors.toList());

    }

}
