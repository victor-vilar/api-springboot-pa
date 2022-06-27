package com.victorvilar.projetoempresa.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.victorvilar.projetoempresa.entities.Client;

@RestController
public class ClientController {

	private final ClientService as service;
	
	public ClientController(ClientService as service) {
		this.service = service;
	}
	
	/**
	 * get all clients
	 * @param as
	 */
	@GetMapping("/clients")
	public List<Client> getClients(){
		
	}
	
	/**
	 * Sing in a new Client
	 * @param as
	 */
	@PostMapping("/clients/")
	public void addNewClient(@RequestBody Client as client) {
		this.service.addNewClient(client);
	}
	
}
