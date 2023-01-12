package com.victorvilar.projetoempresa.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.victorvilar.projetoempresa.controllers.dto.client.ClientCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.client.ClientResponseDto;
import com.victorvilar.projetoempresa.domain.Client;
import com.victorvilar.projetoempresa.mappers.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.victorvilar.projetoempresa.services.ClientService;

import javax.validation.Valid;

/**
 * A client contoller
 * @author Victor Vilar
 */
@RestController
@RequestMapping("/clients")
//@CrossOrigin(origins = {"http://http://127.0.0.1:5500", "http://localhost:8080"})

public class ClientController {

	
	private final ClientService service;
	private final ClientMapper mapper;
	
	@Autowired
	public ClientController(ClientService service, ClientMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	/**
	 * return all clients of repository and transform in a responseDto
	 * @return a listOfResponseDto
	 */
	@GetMapping()
	public ResponseEntity<List<ClientResponseDto>> getAllClients(){
		List<ClientResponseDto> listResponseDto = new ArrayList<>();
		listResponseDto = mapper.toClientResponseDtoList(this.service.getAllClients());
		return new ResponseEntity<>(listResponseDto, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClientResponseDto> getClientById(@PathVariable String id) {
			return new ResponseEntity<>(mapper.toClientResponseDto(this.service.getClientById(id)),HttpStatus.FOUND);
	}

	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
	public void addNewClient(@Valid @RequestBody ClientCreateDto clientDto){
			this.service.addNewClient(mapper.toClient(clientDto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClientResponseDto> updateCliente(@PathVariable String id, @RequestBody ClientCreateDto clientDto){
		return new ResponseEntity<>(this.mapper.toClientResponseDto(this.service.updateClient(id,clientDto)),HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteClientById(@PathVariable String id){
		this.service.deleteClientById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}