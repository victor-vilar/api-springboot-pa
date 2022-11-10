package com.victorvilar.projetoempresa.controllers;

import java.util.List;

import com.victorvilar.projetoempresa.controllers.dto.Client.ClientCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.Client.ClientResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public List<ClientResponseDto> getAllClients(){
		return this.service.getAllClients();
	}
	
	@GetMapping("/{id}")
	public ClientResponseDto getClientById(@PathVariable Long id) {
			return this.service.getClientById(id);
	}

	@PostMapping()
	public void addNewClient(@RequestBody ClientCreateDto clientDto){
			this.service.addNewClient(clientDto);
	}



}