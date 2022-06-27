package com.victorvilar.projetoempresa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorvilar.projetoempresa.entities.Client;
import com.victorvilar.projetoempresa.exceptions.InvalidCpfOrCnpjException;
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
	 * get all clients
	 * @param as
	 */
	public List<Client> getAllClients() {
		return this.repository.findAll();
	}
	
	/**
	 * Sing in a new Client
	 * @param as
	 */
	public void addNewClient(Client client) throws InvalidCpfOrCnpjException {
		
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
	public Client getClientById(Long id) {
		return this.repository.findById(id).orElse(null);
	}

}
