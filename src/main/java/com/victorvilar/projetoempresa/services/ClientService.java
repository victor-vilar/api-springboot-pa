package com.victorvilar.projetoempresa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorvilar.projetoempresa.entities.Client;
import com.victorvilar.projetoempresa.repository.ClientRepository;

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
	public void addNewClient(Client client) {
		this.repository.save(client);
		
	}

}
