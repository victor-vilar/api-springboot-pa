package com.victorvilar.projetoempresa.services;

import java.util.List;
import java.util.stream.Collectors;

import com.victorvilar.projetoempresa.controllers.dto.Client.ClientCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.Client.ClientResponseDto;
import com.victorvilar.projetoempresa.exceptions.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorvilar.projetoempresa.exceptions.InvalidCpfOrCnpjException;
import com.victorvilar.projetoempresa.model.Client;
import com.victorvilar.projetoempresa.repository.ClientRepository;
import com.victorvilar.projetoempresa.util.CpfCnpjValidator;

@Service
public class ClientService {

	
	private final ClientRepository repository;
	
	@Autowired
	public ClientService(ClientRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * get all clients, transform in a clientResponseDto list and return;
	 * @param
	 */
	public List<ClientResponseDto> getAllClients() {
		List<Client> clients = this.repository.findAll();
		return  clients.stream().map(e ->{
			ClientResponseDto clientResponseDto = new ClientResponseDto();
			clientResponseDto.ClientToClientResponseDto(e);
			return clientResponseDto;
		} ).collect(Collectors.toList());


	}
	
	/**
	 * Sing in a new Client
	 * @param
	 */
	public void addNewClient(ClientCreateDto clientDto) throws InvalidCpfOrCnpjException {

		//transforming in a client
		Client client = clientDto.ClientDtoToClient();

		//if the cpf or cnpj is valid, it saves the client
		if(CpfCnpjValidator.checkIfIsValid(client.getCpfCnpj())) {
			
			//upper case client name
			client.setNameCompanyName(client.getNameCompanyName().toUpperCase());
			this.repository.save(client);
			
		}else {
			throw new InvalidCpfOrCnpjException("This CPF or CNPJ is Invalid");
		}

		
	}
	/**
	 * Return a client with this id, or return null;
	 * @param id
	 * @return
	 */
	public ClientResponseDto getClientById(Long id) throws ClientNotFoundException{
		ClientResponseDto clientResponseDto= new ClientResponseDto();
		Client client = this.repository.findById(id).orElseThrow(() ->new ClientNotFoundException("This client doesn't exist"));
		clientResponseDto.ClientToClientResponseDto(client);
		return clientResponseDto;
	}

}
