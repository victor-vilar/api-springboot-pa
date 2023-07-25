package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.controllers.dto.contract.*;
import com.victorvilar.projetoempresa.domain.*;
import com.victorvilar.projetoempresa.domain.customer.Contract;
import com.victorvilar.projetoempresa.domain.customer.Customer;
import com.victorvilar.projetoempresa.domain.customer.ItemContract;
import com.victorvilar.projetoempresa.exceptions.ContractNotFoundException;
import com.victorvilar.projetoempresa.exceptions.SupervisorNotFoundException;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

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

    ItemContract itemContract1;
    ItemContract itemContract2;

    List<ItemContract> itens = new ArrayList<>();



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
        when(this.contractMapper.toContractResponseDtoList(Mockito.anyList())).thenReturn(List.of(contractResponseDto1,contractResponseDto1));
        List<ContractResponseDto> list = this.contractService.getAll();
        Assertions.assertNotNull(list);
        Assertions.assertEquals(2,list.size());

    }

    @Test
    @DisplayName("Get all by customer id when successfully")
    public void getAllByCustomer_WhenSuccessfull() {
        when(this.contractRepository.findByCustomerCpfCnpj(anyString())).thenReturn(anyList());
        when(this.contractMapper.toContractResponseDtoList(List.of(contract1,contract2))).thenReturn(List.of(contractResponseDto1,contractResponseDto2));
        List<ContractResponseDto> list = this.contractService.getAllByCustomerId(customer.getCpfCnpj());
        Assertions.assertNotNull(list);
        Assertions.assertEquals(2,list.size());
        Assertions.assertEquals("1000",list.get(0).getNumber());
        Assertions.assertEquals("2000",list.get(1).getNumber());
    }

    @Test
    @DisplayName("Get all by customer id when customer not found")
    public void getAllByCustomer_ReturnEmpty_WhenCustomerNotFound(){
        when(contractRepository.findByCustomerCpfCnpj(anyString())).thenReturn(anyList());
        List<ContractResponseDto> list = this.contractService.getAllByCustomerId(customer.getCpfCnpj());
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Get contract by id when successfully")
    public void getById_WhenSuccessfull() {
        when(this.contractRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(contract1));
        when(this.contractMapper.toContractResponseDto(any(Contract.class))).thenReturn(contractResponseDto1);

        ContractResponseDto contractResponseDto = this.contractService.getById(2L);
        Assertions.assertEquals(contract1.getId(),contractResponseDto.getId());
        Assertions.assertEquals(contract1.getBeginDate(),contractResponseDto.getBeginDate());
        Assertions.assertEquals(contract1.getEndDate(),contractResponseDto.getEndDate());

    }

    @Test
    @DisplayName("get by id throws ContractNotFoundException when contract not found")
    public void getById_throwsContractNotFoundException() {
        when(this.contractRepository.findById(1L))
                .thenThrow(new ContractNotFoundException("Contract Not Found !"));
        ContractNotFoundException exception =
                Assertions.assertThrows(ContractNotFoundException.class,() ->
                        this.contractService.getById(1L));
        Assertions.assertEquals(exception.getClass(), ContractNotFoundException.class);
        Assertions.assertEquals("Contract Not Found !",exception.getMessage());
    }

    @Test
    @DisplayName("find by id when successfull")
    public void findByContractId_WhenSuccessfull(){
        when(this.contractRepository.findById(anyLong())).thenReturn(Optional.of(contract1));
        Contract contract = this.contractService.findByContractId(1L);
        Assertions.assertEquals(contract1.getId(),contract.getId());
        Assertions.assertEquals(contract1.getNumber(),contract.getNumber());
    }

    @Test
    @DisplayName("find throws ContractNotFoundException when contract not found")
    public void findByContractId_throwsContractNotFoundException() {
        when(this.contractRepository.findById(1L))
                .thenThrow(new ContractNotFoundException("Contract Not Found !"));
        ContractNotFoundException exception =
                Assertions.assertThrows(ContractNotFoundException.class,() ->
                        this.contractService.findByContractId(1L));
        Assertions.assertEquals(exception.getClass(), ContractNotFoundException.class);
        Assertions.assertEquals("Contract Not Found !",exception.getMessage());
    }


    @Test
    @DisplayName("save successfully when pass a valid contract")
    void save_Successfully_WhenPassAValidContract(){

        when(this.contractMapper.toContract(any(ContractCreateDto.class)))
                .thenReturn(contract1);
        when(this.customerService.findCustomerById(anyString()))
                .thenReturn(customer);
        when(this.itemContractMapper.fromItemContractCreateDtoListToItemContractList(anyList()))
                .thenReturn(itens);
        when(this.contractRepository.save(any(Contract.class)))
                .thenReturn(contract1);
        when(this.contractMapper.toContractResponseDto(contract1))
                .thenReturn(contractResponseDto1);

        ContractResponseDto contractResponseDto = this.contractService.save(contractCreateDto1);

        verify(this.customerRepository,times(1)).save(any(Customer.class));
        Assertions.assertEquals(contract1.getNumber(),contractResponseDto.getNumber());
        Assertions.assertEquals(contract1.getItens().size(),contractResponseDto.getItens().size());

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


        contractUpdateDto2 = ContractUpdateDto.builder()
                .number("2000")
                .beginDate(LocalDate.of(2023,11,11))
                .endDate(LocalDate.of(2024,11,11))
                .customer(customer.getCpfCnpj())
                .build();

        contractUpdateDto2.setItens(
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
                .number("2000")
                .beginDate(LocalDate.of(2023,11,11))
                .endDate(LocalDate.of(2024,11,11))
                .customer(customer.getCpfCnpj())
                .build();

        contractResponseDto2.setItens(
                Arrays.asList(
                        new ItemContractResponseDto(1L,residue.getType(),equipment.getEquipmentName(),10d,10d),
                        new ItemContractResponseDto(2L,residue.getType(),equipment.getEquipmentName(),10d,10d)));

    }
    private void setUpItemContract(){
        itemContract1 = new ItemContract(residue,equipment,10d,10d);
        itemContract2 = new ItemContract(residue,equipment,20d,20d);
        itens.addAll(Arrays.asList(itemContract1,itemContract2));
    }



}