package com.victorvilar.projetoempresa.controllers;

import java.util.ArrayList;
import java.util.List;

import com.victorvilar.projetoempresa.controllers.dto.customer.CustomerCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.customer.CustomerResponseDto;
import com.victorvilar.projetoempresa.domain.customer.Customer;
import com.victorvilar.projetoempresa.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.victorvilar.projetoempresa.services.CustomerService;

import jakarta.validation.Valid;

/**
 * A client contoller
 * @author Victor Vilar
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	
	private final CustomerService service;

	@Autowired
	public CustomerController(CustomerService service, CustomerMapper mapper) {
		this.service = service;

	}

	/**
	 * return all clients of repository
	 * @return a listOfResponseDto
	 */
	@GetMapping()
	public ResponseEntity<List<CustomerResponseDto>> getAllCustomer(){
		return ResponseEntity.ok(this.service.getAllCustomers());
	}

	/**
	 * return a customer by id
	 * @param id id of the customer
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable String id) {
		return ResponseEntity.ok(this.service.getCustomerById(id));
	}

	/**
	 * Add new customer
	 * @param customerDto
	 * @return
	 */
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerResponseDto> addNewCustomer(@Valid @RequestBody CustomerCreateDto customerDto){
		return ResponseEntity.ok(this.service.addNewCustomer(customerDto));

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