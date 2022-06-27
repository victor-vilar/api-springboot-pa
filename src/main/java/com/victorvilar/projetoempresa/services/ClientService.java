package com.victorvilar.projetoempresa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorvilar.projetoempresa.entities.Client;
import com.victorvilar.projetoempresa.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private final ClientRepository repository;
	
	
	public ClientService(ClientRepository repository) {
		this.repository = repository;
	}
	
	public List<Client> getAllClients() {
		return this.repository.findAll();
	}

	public void addNewClient(Client client) {
		this.repository.save(client);
		
	}

}
