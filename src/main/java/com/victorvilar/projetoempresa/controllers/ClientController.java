package com.victorvilar.projetoempresa.controllers;

import java.util.List;

import com.victorvilar.projetoempresa.controllers.dto.Client.ClientCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.Client.ClientResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<ClientResponseDto>> getAllClients(){
		return new ResponseEntity<>(this.service.getAllClients(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientResponseDto> getClientById(@PathVariable String id) {
			return new ResponseEntity<>(this.service.getClientById(id),HttpStatus.FOUND);
	}

	@PostMapping()
	public void addNewClient(@RequestBody ClientCreateDto clientDto){
			this.service.addNewClient(clientDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteClientById(@PathVariable String id){
		this.service.deleteClientById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}