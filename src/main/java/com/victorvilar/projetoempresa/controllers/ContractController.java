package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.contract.ContractCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ContractResponseDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ContractUpdateDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ItemContractCreateDto;
import com.victorvilar.projetoempresa.domain.*;
import com.victorvilar.projetoempresa.mappers.ContractMapper;
import com.victorvilar.projetoempresa.mappers.ItemContractMapper;
import com.victorvilar.projetoempresa.services.CustomerService;
import com.victorvilar.projetoempresa.services.ContractService;
import com.victorvilar.projetoempresa.services.EquipmentService;
import com.victorvilar.projetoempresa.services.ResidueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

/**
 *  contract controller
 * @author Victor Vilar
 */
@RestController
@RequestMapping("/contracts")
public class ContractController {

    private final ContractService service;
    private final ContractMapper mapper;
    private final CustomerService customerService;
    private final ItemContractMapper itemContractMapper;
    private final ResidueService residueService;
    private final EquipmentService equipmentService;

    @Autowired
    public ContractController(ContractService service,
                              ContractMapper mapper,
                              CustomerService customerService,
                              ItemContractMapper itemContractMapper,
                              ResidueService residueService,
                              EquipmentService equipmentService
){
        this.service = service;
        this.mapper= mapper;
        this.customerService = customerService;
        this.itemContractMapper = itemContractMapper;
        this.residueService = residueService;
        this.equipmentService = equipmentService;

    }

    /**
     * Get all contracts
     * @return list of contracts
     */
    @GetMapping()
    public ResponseEntity<List<ContractResponseDto>> getAllContracts(){
        return new ResponseEntity<List<ContractResponseDto>>(
                this.mapper.toContractResponsDtoList(this.service.getAllContracts()),
                HttpStatus.OK
        );
    }

    /**
     * Get all contracts of a client
     * @param clientId
     * @return
     */
    @GetMapping("/all/{clientId}")
    public ResponseEntity<List<ContractResponseDto>> getAllContractsByClientId(@PathVariable String clientId){
        return new ResponseEntity<List<ContractResponseDto>>(
                this.mapper.toContractResponsDtoList(
                        this.service.getAllContractsByClientId(clientId)),HttpStatus.OK);
    }

    /**
     * get contract by id
     * @return contract
     */
    @GetMapping("/{id}")
    public ResponseEntity<ContractResponseDto> getContractById(@PathVariable Long id) {
        return new ResponseEntity<ContractResponseDto>(
                this.mapper.toContractResponseDto(
                        this.service.getContractById(id)),HttpStatus.OK);
    }


    /**
     *
     * add new contract
     *
     * @param contract a model to contract
     */
    @PostMapping()
    public ResponseEntity<ContractResponseDto> addNewContract(@Valid @RequestBody ContractCreateDto contract) {

        //contractCreateDto to Contract
        Contract contract1 = this.mapper.toContract(contract);

        if(contract.getItens().isEmpty()){
            throw new RuntimeException("contract must have at least one item");
        }

        //transform itemContractCreateList into a ItemContractList and add to contract
        this.itemContractMapper.fromItemContractCreateDtoListToItemContractList(contract.getItens()).stream().forEach(item -> contract1.addNewItem(item));

        //get client from database
        Customer customer = customerService.findCustomerById(contract.getCustomerId());

        //add contract to customer
        customer.addNewContract(contract1);

        //return saved contract
        return new ResponseEntity<ContractResponseDto>
                (this.mapper.toContractResponseDto(this.service.save(contract1)),HttpStatus.OK);
    }


    /**
     * add a new item to a contract
     * @param contractId id of a saved contract
     */
    @PostMapping("/additem/{contractId}")
    public ResponseEntity<ContractResponseDto> addNewItemToContract(@PathVariable Long contractId, @Valid @RequestBody ItemContractCreateDto itemDto){

        ItemContract item = this.itemContractMapper.toItemContract(itemDto);
        this.service.addNewItemToContract(contractId, item);
        Contract contract = this.service.getContractById(contractId);
        return new ResponseEntity<ContractResponseDto>(
                this.mapper.toContractResponseDto(contract),HttpStatus.OK);
    }


    /**
     * remove a contract from db
     * @param contractId
     */
    @DeleteMapping("/{contractId}")
    public ResponseEntity<?> removeContract(@PathVariable Long contractId ){
        this.service.removeContract(contractId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * remove a item from a contract
     * @param itemId
     */
    @DeleteMapping("/deleteitem/{itemId}")
    public ResponseEntity<ContractResponseDto> removeItemContract(@PathVariable Long itemId){
        return new ResponseEntity<ContractResponseDto>(
                this.mapper.toContractResponseDto(this.service.removeItemContract(itemId)),HttpStatus.OK);
    }


    /**
     * Update contract
     * @param contractId
     * @return
     */
    @PutMapping("/{contractId}")
    public ResponseEntity<ContractResponseDto> updateContract(@PathVariable Long contractId,
                                                              @RequestBody ContractUpdateDto contractUpdateDto){

        //creates instance of contract
        Contract contract = this.mapper.toContract(contractUpdateDto);

        //find contract's customer
        contract.setCustomer(this.customerService.findCustomerById(contractUpdateDto.getCustomerId()));

        //if the contract to update has no itens, throw error
        if(contractUpdateDto.getItens().isEmpty()){
            throw new RuntimeException("contract must have at least one item");
        }

        //update each value of contract and get savedContract
        Contract savedContract = this.service.updateContract(contractId, contract);

        //transform itemContractCreateList into a ItemContractList and add to contract
        List<ItemContract> lista = this.itemContractMapper.fromItemContractUpdateDtoListToItemContractList(contractUpdateDto.getItens());

        //loop to insert a new item or update an exist one
        lista.stream().forEach(item ->{
            if(item.getId() == null){
                savedContract.addNewItem(item);
            }else{
                this.service.updateItemContract(savedContract,item);
            }
        });
        this.service.save(savedContract);
        return new ResponseEntity<ContractResponseDto>(this.mapper.toContractResponseDto(savedContract), HttpStatus.OK);


    }

}
