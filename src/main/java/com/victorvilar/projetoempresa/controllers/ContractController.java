package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.contract.ContractResponseDto;
import com.victorvilar.projetoempresa.exceptions.ClientNotFoundException;
import com.victorvilar.projetoempresa.exceptions.ContractNotFoundException;
import com.victorvilar.projetoempresa.domain.Contract;
import com.victorvilar.projetoempresa.domain.ItemContract;
import com.victorvilar.projetoempresa.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public ContractController(ContractService service){
        this.service = service;
    }

    /**
     * Get all contracts
     * @return list of contracts
     */
    @GetMapping()
    public ResponseEntity<List<ContractResponseDto>> getAllContracts(){
        //TODO ------------>
        return null;
    }

    /**
     * Get all contracts of a client
     * @param clientId
     * @return
     */
    @GetMapping("/{clientId}")
    public ResponseEntity<List<ContractResponseDto>> getAllContractsByClientId(@PathVariable String clientId){
        //TODO ------------>
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
     * @param itens a list of the itens of the contract
     */

    @PostMapping("/{clientId}")
    public void addNewContract(@PathVariable String clientId, @RequestBody List<ItemContract> itens) {
        //TODO ------------>
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
