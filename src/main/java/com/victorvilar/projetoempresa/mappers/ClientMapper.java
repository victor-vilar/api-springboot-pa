package com.victorvilar.projetoempresa.mappers;

import com.victorvilar.projetoempresa.controllers.dto.client.ClientCreateDto;
import com.victorvilar.projetoempresa.domain.Client;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    private ModelMapper mapper;

    @Autowired
    public ClientMapper(ModelMapper map){
        this.mapper = map;
    }

    public Client toClient(ClientCreateDto clientCreate){
        return this.mapper.map(clientCreate, Client.class);
    }
}
