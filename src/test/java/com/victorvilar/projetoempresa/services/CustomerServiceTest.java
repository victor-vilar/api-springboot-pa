package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.controllers.dto.customer.CustomerCreateDto;
import com.victorvilar.projetoempresa.domain.customer.Customer;
import com.victorvilar.projetoempresa.exceptions.CpfOrCnpjAlreadyExistsException;
import com.victorvilar.projetoempresa.exceptions.CustomerNotFoundException;
import com.victorvilar.projetoempresa.exceptions.InvalidCpfOrCnpjException;
import com.victorvilar.projetoempresa.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Customer service tests class")
class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository repository;


    Customer cpfCustomer;
    Customer cnpjCustomer;
    Customer wrongCpfCustomer;
    Customer wrongCnpjCustomer;
    Customer nullCpfCnpjCustomer;
    Customer nullNameCompanyNameCustomer;
    CustomerCreateDto customerDto;


    @BeforeEach
    void setUp(){
        cpfCustomer = new Customer.CustomerBuilder()
                .nameCompanyName("cpfCustomer")
                .cpfCnpj("86570192051")
                .build();


        cnpjCustomer = new Customer.CustomerBuilder()
                .nameCompanyName("cnpjCustomer")
                .cpfCnpj("48153741000139")
                .build();


        wrongCpfCustomer = new Customer.CustomerBuilder()
                .nameCompanyName("cnpjCustomer")
                .cpfCnpj("86570192055")
                .build();

        wrongCnpjCustomer = new Customer.CustomerBuilder()
                .nameCompanyName("cnpjCustomer")
                .cpfCnpj("48153741000133")
                .build();

        nullCpfCnpjCustomer = new Customer.CustomerBuilder()
                .nameCompanyName("cnpjCustomer")
                .build();


        nullNameCompanyNameCustomer = new Customer.CustomerBuilder()
                .cpfCnpj("48153741000133")
                .build();

        customerDto = new CustomerCreateDto.CustomerCreateDtoBuilder()
                .nameCompanyName("dtoCustomer")
                .cpfCnpj("48153741000139")
                .build();

    }



    @Test
    @DisplayName("addNewCustomer  successfully when passing cpf")
    void addNewCustomer_Successfully_WhenPassingValidCpf(){
        when(repository.findByCpfCnpj(cpfCustomer.getCpfCnpj())).thenReturn(Optional.empty());
        when(repository.save(cpfCustomer)).thenReturn(cpfCustomer);
        Customer savedCustomer = customerService.addNewCustomer(cpfCustomer);
        assertEquals(cpfCustomer.getCpfCnpj(),savedCustomer.getCpfCnpj());
        Mockito.verifyNoMoreInteractions(repository);
    }

    @Test
    @DisplayName("save successfully when passing cnpj")
    void addNewCustomer_Successfully_WhenPassingValidCnpj(){
        when(repository.findByCpfCnpj(cnpjCustomer.getCpfCnpj())).thenReturn(Optional.empty());
        when(repository.save(cnpjCustomer)).thenReturn(cnpjCustomer);
        Customer savedCustomer = customerService.addNewCustomer(cnpjCustomer);
        assertEquals(cnpjCustomer.getCpfCnpj(),savedCustomer.getCpfCnpj());
        Mockito.verifyNoMoreInteractions(repository);
    }


    @Test
    @DisplayName("save throws InvalidCpfOrCnpjException when passing a invalid cpf")
    void addNewCustomer_ThrowsInvalidCpfOrCnpjException_WhenPassAnInvalidCpf(){

        when(repository.findByCpfCnpj(wrongCpfCustomer.getCpfCnpj())).thenReturn(Optional.empty());
        InvalidCpfOrCnpjException exception =
                Assertions.assertThrows(InvalidCpfOrCnpjException.class,() -> this.customerService.addNewCustomer(wrongCpfCustomer));

        assertNotEquals(exception,null);
        assertEquals(exception.getMessage(),"This CPF or CNPJ is Invalid");
        Mockito.verifyNoMoreInteractions(repository);


    }

    @Test
    @DisplayName("save throws InvalidCpfOrCnpjException when passing a invalid cnpj")
    void addNewCustomer_ThrowsInvalidCpfOrCnpjException_WhenPassAnInvalidCnpj(){

        when(repository.findByCpfCnpj(wrongCnpjCustomer.getCpfCnpj())).thenReturn(Optional.empty());
        InvalidCpfOrCnpjException exception =
                Assertions.assertThrows(InvalidCpfOrCnpjException.class,() -> this.customerService.addNewCustomer(wrongCnpjCustomer));

        assertNotEquals(exception,null);
        assertEquals(exception.getMessage(),"This CPF or CNPJ is Invalid");

    }

    @Test
    @DisplayName("save throws NullPointerException when passing a null cpf or cnpj")
    void save_ThrowsNullPointerException_WhenPassAnNullCpfOrCnpj(){

        NullPointerException exception = Assertions.assertThrows(NullPointerException.class,() -> this.customerService.addNewCustomer(nullCpfCnpjCustomer));
        assertNotEquals(exception,null);
        assertEquals(exception.getClass(), NullPointerException.class);
        assertEquals(exception.getMessage(),"The customer must have a cpf or cnpj");
        Mockito.verifyNoMoreInteractions(repository);
    }

    @Test
    @DisplayName("save throws NullPointerException when passing a null nameCompanyName")
    void save_ThrowsNullPointerException_WhenPassAnNullNameCompanyName(){

        NullPointerException exception = Assertions.assertThrows(NullPointerException.class,() -> this.customerService.addNewCustomer(nullNameCompanyNameCustomer));
        assertNotEquals(exception,null);
        assertEquals(exception.getClass(), NullPointerException.class);
        assertEquals(exception.getMessage(),"The customer must have a name");
        Mockito.verifyNoMoreInteractions(repository);

    }


    @Test
    @DisplayName("save throws CpfOrCnpjAlreadyExists when already exists")
    void save_ThrowsCpfCnpjAlreadyExistsException_WhenSavesAnAlreadyExistCpfCnpj(){

        when(repository.findByCpfCnpj(cpfCustomer.getCpfCnpj())).thenReturn(Optional.of(cpfCustomer));
        CpfOrCnpjAlreadyExistsException exception =
                Assertions.assertThrows(CpfOrCnpjAlreadyExistsException.class,() -> this.customerService.addNewCustomer(cpfCustomer));
        assertNotEquals(exception,null);
        assertEquals(exception.getClass(), CpfOrCnpjAlreadyExistsException.class);
        assertEquals(exception.getMessage(),"This Cpf/Cnpj already exists");
        Mockito.verifyNoMoreInteractions(repository);
    }


    @Test
    @DisplayName("delete throw CustomerNotFoundException when cpf/cnpj doesn't exist")
    void delete_ThrowsCustomerNotFoundException_WhenCpfCnpjIsWrong(){
        Assertions.assertThrows(CustomerNotFoundException.class,() ->this.customerService.deleteCustomerById("1234"));
    }


    @Test
    @DisplayName("find customer by cpfCnpj when successfull")
    void find_Successfully_WhenPassValidCpfCnpj(){

        when(repository.findByCpfCnpj("86570192051")).thenReturn(Optional.of(cpfCustomer));
        Customer savedCustomer = customerService.findCustomerById("86570192051");
        assertEquals(cpfCustomer.getCpfCnpj(),savedCustomer.getCpfCnpj());
        assertEquals(cpfCustomer.getNameCompanyName(),savedCustomer.getNameCompanyName());
        Mockito.verifyNoMoreInteractions(repository);
    }

    @Test
    @DisplayName("find throw CustomerNotFoundException when cpf/cnpj is wrong")
    void find_ThrowsCustomerNotFoundException_WhenCpfCnpjIsWrong(){
        when(repository.findByCpfCnpj(Mockito.anyString())).thenReturn(Optional.empty());
        CustomerNotFoundException exception = Assertions.assertThrows(CustomerNotFoundException.class,() ->this.customerService.findCustomerById("86570192051"));
        assertEquals(exception.getMessage(),"This client doesn't exist");
        assertNotEquals(exception,null);
        assertEquals(exception.getClass(), CustomerNotFoundException.class);
        Mockito.verifyNoMoreInteractions(repository);
    }


    @Test
    @DisplayName("update customer when successfull")
    void update_Successfully_WhenPassValidCpfCnpj(){
        when(repository.findByCpfCnpj(Mockito.anyString())).thenReturn(Optional.of(cpfCustomer));
        when(repository.save(Mockito.any(Customer.class))).thenReturn(cpfCustomer);
        Customer updatedCustomer = this.customerService.updateClient("86570192051",customerDto);
        assertNotNull(updatedCustomer);
        assertEquals(updatedCustomer.getNameCompanyName(),customerDto.getNameCompanyName());
        assertEquals(updatedCustomer.getCpfCnpj(),customerDto.getCpfCnpj());

    }


}