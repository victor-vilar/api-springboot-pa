package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.entities.Contract;
import com.victorvilar.projetoempresa.entities.ItemContract;
import com.victorvilar.projetoempresa.services.ClientService;
import com.victorvilar.projetoempresa.services.ContractService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  contract contoller
 * @author Victor Vilar
 */
@RestController
@RequestMapping("/contracts")
public class ContractController {

    private final ContractService service;

    public ContractController(ContractService service){
        this.service = service;
    }

    /**
     * Get all contracts
     * @return list of contracts
     */
    @GetMapping()
    public List<Contract> getAllContracts(){

        return this.service.getAllContracts();
    }

    /**
     * get contract by id
     * @return contract
     */
    @GetMapping("/{id}")
    public Contract getContractById(Long id){

        return this.service.getContractById(id);
    }

    /**
     * add new contract
     * @param clientId id of the client
     * @param itens a list of the itens of the contract
     */
    @PostMapping("/{clientId}")
    public void addNewContract(@PathVariable Long clientId, @RequestBody List<ItemContract> itens){
        this.service.addNewContract(clientId,itens);
    }

    /**
     * add a new item to a contract
     * @param contractId id of a saved contract
     */
    @PostMapping("/contract/{contractId}")
    public void addNewItemToContract(@PathVariable Long contractId){
        this.service.addNewItemToContract(contractId);
    }
}
