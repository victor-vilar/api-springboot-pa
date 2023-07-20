package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.contract.ContractCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ContractResponseDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ContractUpdateDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ItemContractCreateDto;
import com.victorvilar.projetoempresa.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;
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
    public ResponseEntity<List<ContractResponseDto>> getAll(){
        return ResponseEntity.ok(this.service.getAll());
    }

    /**
     * Get all contracts of a client
     * @param clientId
     * @return
     */
    @GetMapping("/all/{clientId}")
    public ResponseEntity<List<ContractResponseDto>> getAllByCustomerId(@PathVariable String clientId){
        return ResponseEntity.ok(this.service.getAllByCustomerId(clientId));
    }

    /**
     * get contract by id
     * @return contract
     */
    @GetMapping("/{id}")
    public ResponseEntity<ContractResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.getById(id));
    }


    /**
     * add new contract
     * @param contract a model to contract
     */
    @PostMapping()
    public ResponseEntity<ContractResponseDto> save(@Valid @RequestBody ContractCreateDto contract) {
        return ResponseEntity.ok(this.service.save(contract));
    }


    /**
     * add a new item to a contract
     * @param contractId id of a saved contract
     */
    @PostMapping("/additem/{contractId}")
    public ResponseEntity<ContractResponseDto> addNewItemToContract(@PathVariable Long contractId, @Valid @RequestBody ItemContractCreateDto itemDto){
        return ResponseEntity.ok(this.service.addNewItemToContract(contractId,itemDto));
    }


    /**
     * remove a contract from db
     * @param contractId
     */
    @DeleteMapping("/{contractId}")
    public ResponseEntity<?> delete(@PathVariable Long contractId ){
        this.service.delete(contractId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * remove a item from a contract
     * @param itemId
     */
    @DeleteMapping("/deleteitem/{itemId}")
    public ResponseEntity<ContractResponseDto> deleteItemContract(@PathVariable Long itemId){
        return ResponseEntity.ok(this.service.deleteItemContract(itemId));
    }


    /**
     * Update contract
     * @param contractId
     * @return
     */
    @PutMapping("/{contractId}")
    public ResponseEntity<ContractResponseDto> update(@PathVariable Long contractId,
                                                              @RequestBody ContractUpdateDto contractUpdateDto){

        return ResponseEntity.ok(this.service.update(contractId,contractUpdateDto));

    }

}
