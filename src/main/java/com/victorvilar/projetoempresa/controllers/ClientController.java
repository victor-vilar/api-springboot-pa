package com.victorvilar.projetoempresa.controllers;

import java.util.List;

import com.victorvilar.projetoempresa.exceptions.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.victorvilar.projetoempresa.exceptions.InvalidCpfOrCnpjException;
import com.victorvilar.projetoempresa.model.Client;
import com.victorvilar.projetoempresa.services.ClientService;

/**
 * A client contoller
 * @author Victor Vilar
 */
@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = {"http://http://127.0.0.1:5500", "http://localhost:8080"})

public class ClientController {

	
	private final ClientService service;
	
	@Autowired
	public ClientController(ClientService service) {
		this.service = service;
	}


	@GetMapping()
	public List<Client> getAllClients(){
		return this.service.getAllClients();
	}
	
	@GetMapping("/{id}")
	public Client getClientById(@PathVariable Long id) {
		try {
			return this.service.getClientById(id);
		} catch (ClientNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	@PostMapping()
	public void addNewClient(@RequestBody Client client){
		try {
			this.service.addNewClient(client);
		}catch(InvalidCpfOrCnpjException e) {
			System.out.println(e.getMessage());
		}
	
	}



}