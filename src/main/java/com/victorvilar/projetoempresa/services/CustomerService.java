package com.victorvilar.projetoempresa.services;

import java.util.List;

import com.victorvilar.projetoempresa.controllers.dto.customer.CustomerCreateDto;
import com.victorvilar.projetoempresa.domain.Customer;
import com.victorvilar.projetoempresa.exceptions.CustomerNotFoundException;
import com.victorvilar.projetoempresa.exceptions.CpfOrCnpjAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorvilar.projetoempresa.exceptions.InvalidCpfOrCnpjException;
import com.victorvilar.projetoempresa.repository.CustomerRepository;
import com.victorvilar.projetoempresa.util.CpfCnpjValidator;

import javax.transaction.Transactional;

@Service
public class CustomerService {

	
	private final CustomerRepository repository;
	
	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * get all clients, transform in a clientResponseDto list and return;
	 * @param
	 */
	public List<Customer> getAllClients() {
		return this.repository.findAll();
	}
	
	/**
	 * Sing in a new Client
	 * @param customer, a client
	 */
	@Transactional
	public Customer addNewClient(Customer customer) throws InvalidCpfOrCnpjException, CpfOrCnpjAlreadyExistsException {


		//if client with this cpf or cpjs already exists, throws a new exception
		boolean isPresent = this.repository.findByCpfCnpj(customer.getCpfCnpj()).isPresent();
		if(isPresent){
			throw new CpfOrCnpjAlreadyExistsException("This Cpf/Cnpj already exists in database");
		}
		//if the cpf or cnpj is valid, it saves the client
		if(CpfCnpjValidator.checkIfIsValid(customer.getCpfCnpj())) {
			//upper case client name
			customer.setNameCompanyName(customer.getNameCompanyName().toUpperCase());
			return this.repository.save(customer);
		}else {
			throw new InvalidCpfOrCnpjException("This CPF or CNPJ is Invalid");
		}

	}
	/**
	 * Return a client with this id, or return null;
	 * @param id
	 * @return
	 */
	public Customer getClientById(String id) throws CustomerNotFoundException {
		return this.repository.findByCpfCnpj(id).orElseThrow(() ->new CustomerNotFoundException("This client doesn't exist"));
	}

	/**
	 * Delete a client of the database
	 * @param id id of a client
	 */
	@Transactional
	public void deleteClientById(String id) {
		//if the id is not found will throw a exception
		getClientById(id);
		repository.deleteById(id);
	}

	/**
	 * update client
	 * @param clientId
	 * @return
	 */
	public Customer updateClient(String clientId, CustomerCreateDto customerCreateDto) {
		Customer customer = getClientById(clientId);
		customer.setCpfCnpj(customerCreateDto.getCpfCnpj());
		customer.setNameCompanyName(customerCreateDto.getNameCompanyName());
		return repository.save(customer);
	}
}
