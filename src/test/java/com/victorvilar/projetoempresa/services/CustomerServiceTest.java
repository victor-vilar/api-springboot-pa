package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.controllers.dto.customer.CustomerCreateDto;
import com.victorvilar.projetoempresa.domain.Customer;
import com.victorvilar.projetoempresa.exceptions.CpfOrCnpjAlreadyExistsException;
import com.victorvilar.projetoempresa.exceptions.CustomerNotFoundException;
import com.victorvilar.projetoempresa.exceptions.InvalidCpfOrCnpjException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Customer service tests class")
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;


    @Test
    @DisplayName("Test saving new customer")
    void saveCheckIfSavedHaveSameId(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("12525299701").build();
        Assertions.assertEquals(customer.getCpfCnpj(),this.customerService.addNewClient(customer).getCpfCnpj());
    }

    @Test
    @DisplayName("test Must throw an InvalidCpfOrCnpjException")
    void checkIfThrowsInvalidCpfOrCnpjException(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("1252521").build();
        Assertions.assertThrows(InvalidCpfOrCnpjException.class,() -> this.customerService.addNewClient(customer));

    }

    @Test
    @DisplayName("Must throw a This Cpf/Cnpj already exists in database")
    void checkIfThrowsCpfOrCnpjAlreadyExistsException(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("12525299701").build();
        this.customerService.addNewClient(customer);
        Customer customer2 = new Customer.CustomerBuilder().nameCompanyName("teste2").cpfCnpj("12525299701").build();
        Assertions.assertThrows(CpfOrCnpjAlreadyExistsException.class,() -> this.customerService.addNewClient(customer2));

    }

    @Test
    @DisplayName("Must delete a customer by id")
    void checkIfDeletesACustomer(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("12525299701").build();
        this.customerService.addNewClient(customer);
        this.customerService.deleteClientById("12525299701");
        Assertions.assertThrows(CustomerNotFoundException.class,() ->this.customerService.getClientById("12525299701"));
    }


    @Test
    @DisplayName("Must throw a CustomerNotFoundException")
    void checkIfThrowsCustomerNotFoundException(){
        Assertions.assertThrows(CustomerNotFoundException.class,() ->this.customerService.getClientById("1234"));
    }

    @Test
    @DisplayName("Trying to delete a wrong id, must thows CustomerNotFoundException")
    void checIfThrowsCustomerNotFoundExceptionWhenPassAWrongIdToDelete(){
        Assertions.assertThrows(CustomerNotFoundException.class,() ->this.customerService.deleteClientById("1234"));
    }

    @Test
    @DisplayName("Must update customer cpfcpnj and name")
    void checkIfCustomerInfoAreUpdating(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("12525299701").build();
        this.customerService.addNewClient(customer);
        CustomerCreateDto dto = new CustomerCreateDto();
        dto.setCpfCnpj("08454836000178");
        dto.setNameCompanyName("outro Teste");
        Customer updatedCustomer = this.customerService.updateClient("12525299701",dto);
        Assertions.assertEquals(updatedCustomer.getCpfCnpj(),dto.getCpfCnpj());
        Assertions.assertEquals(updatedCustomer.getNameCompanyName(),dto.getNameCompanyName());

    }

}