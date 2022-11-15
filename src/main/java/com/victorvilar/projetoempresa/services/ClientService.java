package com.victorvilar.projetoempresa.services;

import java.util.List;

import com.victorvilar.projetoempresa.controllers.dto.client.ClientCreateDto;
import com.victorvilar.projetoempresa.exceptions.ClientNotFoundException;
import com.victorvilar.projetoempresa.exceptions.CpfOrCnpjAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorvilar.projetoempresa.exceptions.InvalidCpfOrCnpjException;
import com.victorvilar.projetoempresa.domain.Client;
import com.victorvilar.projetoempresa.repository.ClientRepository;
import com.victorvilar.projetoempresa.util.CpfCnpjValidator;

import javax.transaction.Transactional;

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
	public List<Client> getAllClients() {
		return this.repository.findAll();
	}
	
	/**
	 * Sing in a new Client
	 * @param clientDto, will be transformed a client
	 */
	@Transactional
	public void addNewClient(ClientCreateDto clientDto) throws InvalidCpfOrCnpjException, CpfOrCnpjAlreadyExistsException {

		//transforming in a client
		Client client = clientDto.ClientDtoToClient();
		//if client with this cpf or cpjs already exists, throws a new exception
		boolean isPresent = this.repository.findByCpfCnpj(client.getCpfCnpj()).isPresent();
		if(isPresent){
			throw new CpfOrCnpjAlreadyExistsException("This Cpf/Cnpj already exists in database");
		}
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
	public Client getClientById(String id) throws ClientNotFoundException{
		return this.repository.findByCpfCnpj(id).orElseThrow(() ->new ClientNotFoundException("This client doesn't exist"));
	}

	/**
	 * Delete a client of the database
	 * @param id id of a client
	 */
	@Transactional
	public void deleteClientById(String id) {
		//if the id is not found will throw a exception
		getClientById(id);
		repository.deleteById(id);
	}
}
