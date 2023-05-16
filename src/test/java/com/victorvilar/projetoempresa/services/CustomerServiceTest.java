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
    @DisplayName("save when sucessfull when passing cpf")
    void save_whenSucessfull_WhenPassingCpf(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("86570192051").build();
        Assertions.assertEquals(customer.getCpfCnpj(),this.customerService.addNewClient(customer).getCpfCnpj());
    }

    @Test
    @DisplayName("save when sucessfull when passing cnpj")
    void save_whenSucessfull_WhenPassingCnpj(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("58540613000100").build();
        Assertions.assertEquals(customer.getCpfCnpj(),this.customerService.addNewClient(customer).getCpfCnpj());
    }


    @Test
    @DisplayName("save throws InvalidCpfOrCnpjException when passing a invalid cpf")
    void save_ThrowsInvalidCpfOrCnpjException_WhenPassAInvalidCpf(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("12345678912").build();
        Assertions.assertThrows(InvalidCpfOrCnpjException.class,() -> this.customerService.addNewClient(customer));

    }

    @Test
    @DisplayName("save throws InvalidCpfOrCnpjException when passing a invalid cnpj")
    void save_ThrowsInvalidCpfOrCnpjException_WhenPassAInvalidCnpj(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("58540613000155").build();
        Assertions.assertThrows(InvalidCpfOrCnpjException.class,() -> this.customerService.addNewClient(customer));

    }



    @Test
    @DisplayName("save throws CpfOrCnpjAlreadyExists when already exists")
    void save_ThrowsCpfCnpjAlreadyExistsException_WhenSavesAnAlreadyExistCpfCnpj(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("33172519058").build();
        this.customerService.addNewClient(customer);
        Customer customer2 = new Customer.CustomerBuilder().nameCompanyName("teste2").cpfCnpj("33172519058").build();
        Assertions.assertThrows(CpfOrCnpjAlreadyExistsException.class,() -> this.customerService.addNewClient(customer2));

    }

    @Test
    @DisplayName("delete - delete a customer by id when sucessfull")
    void delete_WhenSucessfull(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("06752034060").build();
        this.customerService.addNewClient(customer);
        this.customerService.deleteClientById("06752034060");
        Assertions.assertThrows(CustomerNotFoundException.class,() ->this.customerService.getClientById("06752034060"));
    }

    @Test
    @DisplayName("delete throw CustomerNotFoundException when cpf/cnpj doesn't exist")
    void delete_ThrowsCustomerNotFoundException_WhenCpfCnpjIsWrong(){
        Assertions.assertThrows(CustomerNotFoundException.class,() ->this.customerService.deleteClientById("1234"));
    }


    @Test
    @DisplayName("find customer by cpfCnpj when successfull")
    void find_CustomerByCpfCnpj_WhenSucessfull(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("01216459088").build();
        Customer savedCustomer = this.customerService.addNewClient(customer);
        Assertions.assertEquals(customer.getCpfCnpj(),savedCustomer.getCpfCnpj());
        Assertions.assertEquals(customer.getNameCompanyName(),savedCustomer.getNameCompanyName());
    }

    @Test
    @DisplayName("find throw CustomerNotFoundException when cpf/cnpj is wrong")
    void find_ThrowsCustomerNotFoundException_WhenCpfCnpjIsWrong(){
        Assertions.assertThrows(CustomerNotFoundException.class,() ->this.customerService.getClientById("1234"));
    }


    @Test
    @DisplayName("update customer when successfull")
    void update_CustomerWhenSuccessfull(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("58141426001").build();
        this.customerService.addNewClient(customer);
        CustomerCreateDto dto = new CustomerCreateDto();
        dto.setCpfCnpj("61043722017");
        dto.setNameCompanyName("outro Teste");
        Customer updatedCustomer = this.customerService.updateClient("58141426001",dto);
        Assertions.assertEquals(updatedCustomer.getCpfCnpj(),dto.getCpfCnpj());
        Assertions.assertEquals(updatedCustomer.getNameCompanyName(),dto.getNameCompanyName());

    }

}