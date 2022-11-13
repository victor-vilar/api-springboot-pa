package com.victorvilar.projetoempresa.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.victorvilar.projetoempresa.controllers.dto.client.ClientCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.client.ClientResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


	/**
	 * return all clients of repository and transform in a responseDto
	 * @return a listOfResponseDto
	 */
	@GetMapping()
	public ResponseEntity<List<ClientResponseDto>> getAllClients(){
		List<ClientResponseDto> listResponseDto = new ArrayList<>();
		listResponseDto = this.service.getAllClients()
		.stream().map(e ->{
			ClientResponseDto clientResponseDto = new ClientResponseDto();
			clientResponseDto.ClientToClientResponseDto(e);
			return clientResponseDto;
		} ).collect(Collectors.toList());

		return new ResponseEntity<>(listResponseDto, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClientResponseDto> getClientById(@PathVariable String id) {
			ClientResponseDto clientResponseDto = new ClientResponseDto();
			clientResponseDto.ClientToClientResponseDto(this.service.getClientById(id));
			return new ResponseEntity<>(clientResponseDto,HttpStatus.FOUND);
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