package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.controllers.dto.contract.*;
import com.victorvilar.projetoempresa.domain.*;
import com.victorvilar.projetoempresa.domain.customer.Contract;
import com.victorvilar.projetoempresa.domain.customer.Customer;
import com.victorvilar.projetoempresa.domain.customer.ItemContract;
import com.victorvilar.projetoempresa.mappers.ContractMapper;
import com.victorvilar.projetoempresa.mappers.ItemContractMapper;
import com.victorvilar.projetoempresa.repository.ContractRepository;
import com.victorvilar.projetoempresa.repository.CustomerRepository;
import com.victorvilar.projetoempresa.repository.ItemContractRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Contract service tests class")
class ContractServiceTest {

    @InjectMocks
    private ContractService contractService;

    @Mock
    private ContractRepository contractRepository;

    @Mock
    private ItemContractRepository itemContractRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerService customerService;

    @Mock
    private ContractMapper contractMapper;

    @Mock
    private ItemContractMapper itemContractMapper;

    Contract contract1;
    Contract contract2;

    ContractCreateDto contractCreateDto1;
    ContractCreateDto contractCreateDto2;

    ContractUpdateDto contractUpdateDto1;
    ContractUpdateDto contractUpdateDto2;

    ContractResponseDto contractResponseDto2;
    ContractResponseDto contractResponseDto1;




    Customer customer;
    Residue residue;
    Equipment equipment;

    @BeforeEach
    void setUp(){

        customer = new Customer.CustomerBuilder()
                .cpfCnpj("58141426001")
                .nameCompanyName("teste")
                .build();

        residue = new Residue("residue 1","residue 1");
        equipment = new Equipment("equipment 1",10);


        this.setUpContracts();
        this.setUpContractCreate();
        this.setUpContractUpdate();
        this.setUpContractResponse();









    }

    @Test
    @DisplayName("Get all when successfully")
    public void getAll_WhenSuccessfull(){
        when(this.contractRepository.findAll()).thenReturn(List.of(contract1,contract2));
        when(this.contractMapper.toContractResponsDtoList(Mockito.anyList())).thenReturn(List.of())
    }


    @Test
    @DisplayName("save successfully when pass a valid contract")
    void save_Successfully_WhenPassAValidContract(){



    }

    private void setUpContracts(){
        //contract 1
        contract1 = Contract.builder()
                .number("1000")
                .beginDate(LocalDate.of(2023,11,11))
                .endDate(LocalDate.of(2024,11,11))
                .customer(customer)
                .build();



        //add item to contract 1
        contract1.addNewItem(new ItemContract(residue,equipment,10,10));
        contract1.addNewItem(new ItemContract(residue,equipment,20,20));


        //contract 2
        contract2 = Contract.builder()
                .number("2000")
                .beginDate(LocalDate.of(2023,11,11))
                .endDate(LocalDate.of(2024,11,11))
                .customer(customer)
                .build();

        //add item to contract 2
        contract2.addNewItem(new ItemContract(residue,equipment,10,10));
        contract2.addNewItem(new ItemContract(residue,equipment,20,20));
    }
    private void setUpContractCreate(){

        contractCreateDto1 = ContractCreateDto.builder()
                 .number("1000")
                 .beginDate(LocalDate.of(2023,11,11))
                 .endDate(LocalDate.of(2024,11,11))
                 .customer(customer.getCpfCnpj())
                 .build();

        contractCreateDto1.setItens(
                Arrays.asList(
                new ItemContractCreateDto(residue.getId(),equipment.getId(),10d,10d),
                new ItemContractCreateDto(residue.getId(),equipment.getId(),20d,20d)));


         contractCreateDto2 = ContractCreateDto.builder()
                 .number("2000")
                 .beginDate(LocalDate.of(2023,11,11))
                 .endDate(LocalDate.of(2024,11,11))
                 .customer(customer.getCpfCnpj())
                 .build();

        contractCreateDto2.setItens(
                Arrays.asList(
                new ItemContractCreateDto(residue.getId(),equipment.getId(),10d,10d),
                new ItemContractCreateDto(residue.getId(),equipment.getId(),20d,20d)));


    }
    private void setUpContractUpdate(){

        contractUpdateDto1 = ContractUpdateDto.builder()
                .number("1000")
                .beginDate(LocalDate.of(2023,11,11))
                .endDate(LocalDate.of(2024,11,11))
                .customer(customer.getCpfCnpj())
                .build();

        contractUpdateDto1.setItens(
                Arrays.asList(
                        new ItemContractUpdateDto(1L,residue.getId(),equipment.getId(),10d,10d),
                        new ItemContractUpdateDto(2L,residue.getId(),equipment.getId(),20d,20d)));


        contractUpdateDto1 = ContractUpdateDto.builder()
                .number("2000")
                .beginDate(LocalDate.of(2023,11,11))
                .endDate(LocalDate.of(2024,11,11))
                .customer(customer.getCpfCnpj())
                .build();

        contractUpdateDto1.setItens(
                Arrays.asList(
                        new ItemContractUpdateDto(3L,residue.getId(),equipment.getId(),10d,10d),
                        new ItemContractUpdateDto(4L,residue.getId(),equipment.getId(),20d,20d)));
    }
    private void setUpContractResponse(){

        contractResponseDto1 = ContractResponseDto.builder()
                .number("1000")
                .beginDate(LocalDate.of(2023,11,11))
                .endDate(LocalDate.of(2024,11,11))
                .customer(customer.getCpfCnpj())
                .build();

        contractResponseDto1.setItens(
                Arrays.asList(
                        new ItemContractResponseDto(1L,residue.getType(),equipment.getEquipmentName(),10d,10d),
                        new ItemContractResponseDto(2L,residue.getType(),equipment.getEquipmentName(),10d,10d)));

        contractResponseDto2 = ContractResponseDto.builder()
                .number("1000")
                .beginDate(LocalDate.of(2023,11,11))
                .endDate(LocalDate.of(2024,11,11))
                .customer(customer.getCpfCnpj())
                .build();

        contractResponseDto2.setItens(
                Arrays.asList(
                        new ItemContractResponseDto(1L,residue.getType(),equipment.getEquipmentName(),10d,10d),
                        new ItemContractResponseDto(2L,residue.getType(),equipment.getEquipmentName(),10d,10d)));

    }



}