package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.domain.*;
import com.victorvilar.projetoempresa.exceptions.CustomerNotFoundException;
import com.victorvilar.projetoempresa.repository.ContractRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

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
    Contract contractWithOutCustomer;
    Contract wrongContract;
    Customer customer;
    ResidueType residueType;
    Equipment equipment;

    @BeforeEach
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

        contractWithOutCustomer = new Contract.ContractBuilder()
                .number("1000")
                .beginDate(LocalDate.of(2023,11,11))
                .endDate(LocalDate.of(2024,11,11))
                .build();

        contractWithOutCustomer.addNewItem(new ItemContract(residueType,equipment,10,10));
        contractWithOutCustomer.addNewItem(new ItemContract(residueType,equipment,20,20));

        customer = new Customer.CustomerBuilder()
                .cpfCnpj("58141426001")
                .nameCompanyName("teste")
                .build();


    }


    @Test
    @DisplayName("save successfully when pass a valid contract")
    void save_Successfully_WhenPassAValidContract(){

        Mockito.when(contractRepository.save(contract)).thenReturn(contract);
        Contract savedContract = this.contractService.save(contract);
        assertEquals(savedContract.getNumber(),contract.getNumber());
        assertEquals(savedContract.getBeginDate(),contract.getBeginDate());

    }

    @Test
    @DisplayName("save throws DataIntegrityViolationException when customer is null")
    void save_ThrowsDataIntegrityViolationException_WhenCustomerIsNull(){

        DataIntegrityViolationException exception =
                Assertions.assertThrows(DataIntegrityViolationException.class,() -> this.contractService.save(contractWithOutCustomer));
        Assertions.assertEquals(exception.getClass(),DataIntegrityViolationException.class);
        Mockito.verifyNoMoreInteractions(contractRepository);
    }


}