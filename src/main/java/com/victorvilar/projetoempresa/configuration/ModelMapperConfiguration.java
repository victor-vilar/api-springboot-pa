package com.victorvilar.projetoempresa.configuration;

import com.victorvilar.projetoempresa.controllers.dto.contract.ContractResponseDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ItemContractResponseDto;
import com.victorvilar.projetoempresa.controllers.dto.supervisor.SupervisorResponseDto;
import com.victorvilar.projetoempresa.domain.Contract;
import com.victorvilar.projetoempresa.domain.ItemContract;
import com.victorvilar.projetoempresa.domain.Supervisor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(Supervisor.class, SupervisorResponseDto.class).
                addMappings(maper -> {
                    maper.map(src -> src.getCliente().getCpfCnpj(),SupervisorResponseDto::setClientId);
                });

        mapper.typeMap(Contract.class, ContractResponseDto.class)
                .addMappings(maper ->{
                    maper.map(src -> src.getClient().getCpfCnpj(), ContractResponseDto::setClientId);
                });

        mapper.typeMap(ItemContract.class, ItemContractResponseDto.class)
                .addMappings(maper ->{
                    maper.map(src-> src.getResidue().getType(), ItemContractResponseDto::setResidue);
                    maper.map(src-> src.getEquipament().getEquipamentName(),ItemContractResponseDto::setEquipament);
                });

        return mapper;
    }
}
