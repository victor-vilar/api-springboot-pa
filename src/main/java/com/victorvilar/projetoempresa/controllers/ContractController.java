package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.contract.ContractCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ContractResponseDto;
import com.victorvilar.projetoempresa.domain.Client;
import com.victorvilar.projetoempresa.exceptions.ClientNotFoundException;
import com.victorvilar.projetoempresa.exceptions.ContractNotFoundException;
import com.victorvilar.projetoempresa.domain.Contract;
import com.victorvilar.projetoempresa.domain.ItemContract;
import com.victorvilar.projetoempresa.mappers.ContractMapper;
import com.victorvilar.projetoempresa.services.ClientService;
import com.victorvilar.projetoempresa.services.ContractService;
import com.victorvilar.projetoempresa.services.EquipamentService;
import com.victorvilar.projetoempresa.services.ResidueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private final ClientService clientService;


    @Autowired
    public ContractController(ContractService service,
                              ContractMapper mapper,
                              ClientService clientService
){
        this.service = service;
        this.mapper= mapper;
        this.clientService = clientService;

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

        return null;
    }

    /**
     * get contract by id
     * @return contract
     */
    @GetMapping("/{id}")
    public ResponseEntity<ContractResponseDto> getContractById(Long id) {
        //TODO ------------>
        return null;
    }


    /**
     *
     * add new contract
     * @param clientId id of the client
     * @param contract a model to contract
     */

    @PostMapping("/{clientId}")
    public ResponseEntity<?> addNewContract(@PathVariable String clientId, @RequestBody ContractCreateDto contract) {
        Contract contract1 = this.mapper.toContract(contract);
        Client client = clientService.getClientById(clientId);
        contract1.setClient(client);
        //this.service.addNewContract(contract1, clientId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    /**
     * add a new item to a contract
     * @param contractId id of a saved contract
     */
    @PostMapping("/additem/{contractId}")
    public void addNewItemToContract(@PathVariable String contractId){
        //TODO ------------>
    }



    /**
     * remove a contract from db
     * @param contractId
     */
    @DeleteMapping("/{contractId}")
    public void removeContract(Long contractId ){
        //TODO ------------>
    }

    /**
     * remove a item from a contract
     * @param contractId
     * @param itemId
     */
    @DeleteMapping("/{contractId}/{itemId}")
    public void removeItemContract(Long contractId, Long itemId){
        //TODO ------------>
    }


    /**
     * Update contract
     * @param contractId
     * @return
     */
    @PutMapping("/{contractId}")
    public ResponseEntity<ContractResponseDto> updateContract(Long contractId){
        //TODO ------------>
        return null;
    }

    /**
     * update a item of contract
     * @param contractId
     * @param itemId
     * @return
     */
    @PutMapping("/{contractId}/{itemId}")
    public ResponseEntity<ContractResponseDto> updateItemContract(Long contractId, Long itemId){
        //TODO ------------>
        return null;
    }



}
