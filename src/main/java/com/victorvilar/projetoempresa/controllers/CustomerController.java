package com.victorvilar.projetoempresa.controllers;

import java.util.ArrayList;
import java.util.List;

import com.victorvilar.projetoempresa.controllers.dto.customer.CustomerCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.customer.CustomerResponseDto;
import com.victorvilar.projetoempresa.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.victorvilar.projetoempresa.services.CustomerService;

import javax.validation.Valid;

/**
 * A client contoller
 * @author Victor Vilar
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	
	private final CustomerService service;
	private final CustomerMapper mapper;
	
	@Autowired
	public CustomerController(CustomerService service, CustomerMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	/**
	 * return all clients of repository and transform in a responseDto
	 * @return a listOfResponseDto
	 */
	@GetMapping()
	public ResponseEntity<List<CustomerResponseDto>> getAllCustomer(){
		List<CustomerResponseDto> listResponseDto = new ArrayList<>();
		listResponseDto = mapper.toCustomerResponseDtoList(this.service.getAllCustomers());
		return new ResponseEntity<>(listResponseDto, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable String id) {
			return new ResponseEntity<>(mapper.toCustomerResponseDto(this.service.findCustomerById(id)),HttpStatus.OK);
	}

	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
	public void addNewCustomer(@Valid @RequestBody CustomerCreateDto clientDto){
			this.service.addNewCustomer(mapper.toCustomer(clientDto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerResponseDto> updateCustomer(@PathVariable String id, @RequestBody CustomerCreateDto clientDto){
		return new ResponseEntity<>(this.mapper.toCustomerResponseDto(this.service.updateClient(id,clientDto)),HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable String id){
		this.service.deleteCustomerById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}