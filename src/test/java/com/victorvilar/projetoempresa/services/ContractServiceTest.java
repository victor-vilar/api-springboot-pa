package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.domain.Contract;
import com.victorvilar.projetoempresa.domain.Customer;
import com.victorvilar.projetoempresa.exceptions.CustomerNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Test contractService")
class ContractServiceTest {

    @Autowired
    private ContractService contractService;

    @Autowired
    private CustomerService customerService;


    //creates a customer to save to contract
    private Customer createsCustomerToTestContractService(){
        Customer customer = new Customer.CustomerBuilder()
                .cpfCnpj("58141426001")
                .nameCompanyName("teste")
                .build();
        return this.customerService.addNewCustomer(customer);
    }

    //creates a contract to test
    private Contract createsContractToTestContractService(Customer customer){
        return new Contract.ContractBuilder()
                .number("1000")
                .beginDate(LocalDate.of(2023,11,11))
                .endDate(LocalDate.of(2024,11,11))
                .customer(customer)
                .build();
    }

    @Test
    @DisplayName("save successfully when pass a valid contract")
    void save_Successfully_WhenPassAValidContract(){

        Contract contract = createsContractToTestContractService(createsCustomerToTestContractService());
        Contract savedContract = this.contractService.save(contract);
        Assertions.assertEquals(savedContract.getNumber(),contract.getNumber());

    }

    @Test
    @DisplayName("save throws DataIntegrityViolationException when customer is null")
    void save_ThrowsDataIntegrityViolationException_WhenCustomerIsNull(){
        Contract contract = createsContractToTestContractService(null);
        Assertions.assertThrows(CustomerNotFoundException.class,()-> this.contractService.save(contract));
    }

//    @Test
//    @DisplayName("save throws CustomerNotFoundException when customer is not persisted")
//    void save_ThrowsCustomerNotFoundException_WhenCustomerIsNotPersisted(){
//        Customer customer = new Customer.CustomerBuilder().cpfCnpj("16154617011").nameCompanyName("test").build();
//        Contract contract = createsContractToTestContractService(customer);
//        Assertions.assertThrows(CustomerNotFoundException.class,()-> this.contractService.save(contract));
//    }
}