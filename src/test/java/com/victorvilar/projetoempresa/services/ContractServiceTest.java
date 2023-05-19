package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.domain.*;
import com.victorvilar.projetoempresa.exceptions.CustomerNotFoundException;
import com.victorvilar.projetoempresa.repository.ContractRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Contract service tests class")
class ContractServiceTest {

    @InjectMocks
    private ContractService contractService;

    @Mock
    private CustomerService customerService;

    @Mock
    private ContractRepository contractRepository;


    Contract contract;
    Contract wrongContract;
    Customer customer;
    ResidueType residueType;
    Equipment equipment;

    @BeforeAll
    void setUp(){

        residueType = new ResidueType("residue 1","residue 1");
        equipment = new Equipment("equipment 1",10);


        contract = new Contract.ContractBuilder()
                .number("1000")
                .beginDate(LocalDate.of(2023,11,11))
                .endDate(LocalDate.of(2024,11,11))
                .customer(customer)
                .build();

        contract.addNewItem(new ItemContract(residueType,equipment,10,10));
        contract.addNewItem(new ItemContract(residueType,equipment,20,20));


        customer = new Customer.CustomerBuilder()
                .cpfCnpj("58141426001")
                .nameCompanyName("teste")
                .build();


    }



    @Test
    @DisplayName("save successfully when pass a valid contract")
    void save_Successfully_WhenPassAValidContract(){



    }

    @Test
    @DisplayName("save throws DataIntegrityViolationException when customer is null")
    void save_ThrowsDataIntegrityViolationException_WhenCustomerIsNull(){

    }


}