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

@SpringBootTest
@DisplayName("Customer service tests class")
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;


    @Test
    @DisplayName("save  successfully when passing cpf")
    void save_Successfully_WhenPassingValidCpf(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("86570192051").build();
        Assertions.assertEquals(customer.getCpfCnpj(),this.customerService.addNewCustomer(customer).getCpfCnpj());
    }

    @Test
    @DisplayName("save successfully when passing cnpj")
    void save_Successfully_WhenPassingValidCnpj(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("58540613000100").build();
        Assertions.assertEquals(customer.getCpfCnpj(),this.customerService.addNewCustomer(customer).getCpfCnpj());
    }


    @Test
    @DisplayName("save throws InvalidCpfOrCnpjException when passing a invalid cpf")
    void save_ThrowsInvalidCpfOrCnpjException_WhenPassAnInvalidCpf(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("12345678912").build();
        Assertions.assertThrows(InvalidCpfOrCnpjException.class,() -> this.customerService.addNewCustomer(customer));

    }

    @Test
    @DisplayName("save throws InvalidCpfOrCnpjException when passing a invalid cnpj")
    void save_ThrowsInvalidCpfOrCnpjException_WhenPassAnInvalidCnpj(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("58540613000155").build();
        Assertions.assertThrows(InvalidCpfOrCnpjException.class,() -> this.customerService.addNewCustomer(customer));

    }

    @Test
    @DisplayName("save throws NullPointerException when passing a null cpf or cnpj")
    void save_ThrowsNullPointerException_WhenPassAnNullCpfOrCnpj(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").build();
        Assertions.assertThrows(NullPointerException.class,() -> this.customerService.addNewCustomer(customer));
    }

    @Test
    @DisplayName("save throws NullPointerException when passing a null nameCompanyName")
    void save_ThrowsNullPointerException_WhenPassAnNullNameCompanyName(){
        Customer customer = new Customer.CustomerBuilder().cpfCnpj("58540613000100").build();
        Assertions.assertThrows(NullPointerException.class,() -> this.customerService.addNewCustomer(customer));
    }


    @Test
    @DisplayName("save throws CpfOrCnpjAlreadyExists when already exists")
    void save_ThrowsCpfCnpjAlreadyExistsException_WhenSavesAnAlreadyExistCpfCnpj(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("33172519058").build();
        this.customerService.addNewCustomer(customer);
        Customer customer2 = new Customer.CustomerBuilder().nameCompanyName("teste2").cpfCnpj("33172519058").build();
        Assertions.assertThrows(CpfOrCnpjAlreadyExistsException.class,() -> this.customerService.addNewCustomer(customer2));

    }

    @Test
    @DisplayName("delete a customer by id when passing a valid cpf or cnpj")
    void delete_Successfully_WhenPassValidCpfCnpj(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("06752034060").build();
        this.customerService.addNewCustomer(customer);
        this.customerService.deleteCustomerById("06752034060");
        Assertions.assertThrows(CustomerNotFoundException.class,() ->this.customerService.findCustomerById("06752034060"));
    }

    @Test
    @DisplayName("delete throw CustomerNotFoundException when cpf/cnpj doesn't exist")
    void delete_ThrowsCustomerNotFoundException_WhenCpfCnpjIsWrong(){
        Assertions.assertThrows(CustomerNotFoundException.class,() ->this.customerService.deleteCustomerById("1234"));
    }


    @Test
    @DisplayName("find customer by cpfCnpj when successfull")
    void find_Successfully_WhenPassValidCpfCnpj(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("01216459088").build();
        Customer savedCustomer = this.customerService.addNewCustomer(customer);
        Assertions.assertEquals(customer.getCpfCnpj(),savedCustomer.getCpfCnpj());
        Assertions.assertEquals(customer.getNameCompanyName(),savedCustomer.getNameCompanyName());
    }

    @Test
    @DisplayName("find throw CustomerNotFoundException when cpf/cnpj is wrong")
    void find_ThrowsCustomerNotFoundException_WhenCpfCnpjIsWrong(){
        Assertions.assertThrows(CustomerNotFoundException.class,() ->this.customerService.findCustomerById("1234"));
    }


    @Test
    @DisplayName("update customer when successfull")
    void update_Successfully_WhenPassValidCpfCnpj(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("58141426001").build();
        this.customerService.addNewCustomer(customer);
        CustomerCreateDto dto = new CustomerCreateDto();
        dto.setCpfCnpj("61043722017");
        dto.setNameCompanyName("outro Teste");
        Customer updatedCustomer = this.customerService.updateClient("58141426001",dto);
        Assertions.assertEquals(updatedCustomer.getCpfCnpj(),dto.getCpfCnpj());
        Assertions.assertEquals(updatedCustomer.getNameCompanyName(),dto.getNameCompanyName());

    }

    @Test
    @DisplayName("update throws JpaSystemException when cpf or cnpj is wrong")
    void update_ThrowsCustomerNotFoundException_WhenCpfCnpjIsWrong(){
        Customer customer = new Customer.CustomerBuilder().nameCompanyName("teste").cpfCnpj("58141426001").build();
        this.customerService.addNewCustomer(customer);
        CustomerCreateDto dto = new CustomerCreateDto();
        dto.setNameCompanyName("outro Teste");
        Assertions.assertThrows(CustomerNotFoundException.class,() ->this.customerService.updateClient("58141426000",dto));

    }


}