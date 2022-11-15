package com.victorvilar.projetoempresa.mappers;

import com.victorvilar.projetoempresa.controllers.dto.client.ClientCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.client.ClientResponseDto;
import com.victorvilar.projetoempresa.domain.Client;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public ClientResponseDto toClientResponseDto(Client client){
        return this.mapper.map(client,ClientResponseDto.class);
    }

    public List<ClientResponseDto> toClientResponseDtoList(List<Client> clientes){
        return clientes.stream().map(e -> toClientResponseDto(e)).collect(Collectors.toList());
    }
}
