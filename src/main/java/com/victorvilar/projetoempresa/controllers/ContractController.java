package com.victorvilar.projetoempresa.controllers;

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
    public ResponseEntity<List<ContractResponse>> getAllContracts(){
        return this.service.getAllContracts();
    }

    /**
     * Get all contracts of a client
     * @param clientId
     * @return
     */
    @GetMapping("/{clientId}")
    public ResponseEntity<List<ContractResponse>> getAllContractsByClientId(@PathVariable String clientId){
        //TODO ------------>
    }

    /**
     * get contract by id
     * @return contract
     */
    @GetMapping("/{id}")
    public ResponseEntity<ContractResponse> getContractById(Long id) {
        //TODO ------------>
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
        this.service.addNewItemToContract(contractId);
    }



    /**
     * remove a contract from db
     * @param contractId
     */
    @DeleteMapping()
    public void removeContract(Long contractId ){
        //TODO ------------>
    }

    /**
     * remove a item from a contract
     * @param contractId
     * @param itemId
     */
    @DeleteMapping()
    public void removeItemContract(Long contractId, Long itemId){
        //TODO ------------>
    }



    /**
     * Update contract
     * @param contractId
     * @return
     */
    @PutMapping()
    public ResponseEntity<ContractResponse> updateContract(Long contractId){
        //TODO ------------>
    }

    /**
     * update a item of contract
     * @param contractId
     * @param itemId
     * @return
     */
    @PutMapping()
    public ResponseEntity<ContractResponse> updateItemContract(Long contractId, Long itemId){
        //TODO ------------>
    }



}
