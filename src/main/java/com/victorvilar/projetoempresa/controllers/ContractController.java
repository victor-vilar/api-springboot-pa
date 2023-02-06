package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.contract.ContractCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ContractResponseDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ContractUpdateDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ItemContractCreateDto;
import com.victorvilar.projetoempresa.domain.Customer;
import com.victorvilar.projetoempresa.domain.Contract;
import com.victorvilar.projetoempresa.domain.ItemContract;
import com.victorvilar.projetoempresa.mappers.ContractMapper;
import com.victorvilar.projetoempresa.mappers.ItemContractMapper;
import com.victorvilar.projetoempresa.services.ClientService;
import com.victorvilar.projetoempresa.services.ContractService;
import com.victorvilar.projetoempresa.services.EquipamentService;
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
    private final ClientService clientService;
    private final ItemContractMapper itemContractMapper;
    private final ResidueService residueService;
    private final EquipamentService equipamentService;

    @Autowired
    public ContractController(ContractService service,
                              ContractMapper mapper,
                              ClientService clientService,
                              ItemContractMapper itemContractMapper,
                              ResidueService residueService,
                              EquipamentService equipamentService
){
        this.service = service;
        this.mapper= mapper;
        this.clientService = clientService;
        this.itemContractMapper = itemContractMapper;
        this.residueService = residueService;
        this.equipamentService = equipamentService;

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
        return new ResponseEntity<ContractResponseDto>(this.mapper.toContractResponseDto(this.service.getContractById(id)),HttpStatus.FOUND);
    }


    /**
     *
     * add new contract
     * @param clientId id of the client
     * @param contract a model to contract
     */
    @PostMapping("/{clientId}")
    public ResponseEntity<?> addNewContract(@PathVariable String clientId, @Valid @RequestBody ContractCreateDto contract) {
        Contract contract1 = this.mapper.toContract(contract);
        Customer customer = clientService.getClientById(clientId);
        customer.addNewContract(contract1);
        this.service.save(contract1);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    /**
     * add a new item to a contract
     * @param contractId id of a saved contract
     */
    @PostMapping("/additem/{contractId}")
    public ResponseEntity<?> addNewItemToContract(@PathVariable Long contractId, @Valid @RequestBody ItemContractCreateDto itemDto){
        ItemContract item = this.itemContractMapper.toItemContract(itemDto);
        item.setResidue(this.residueService.findById(itemDto.getResidue()));
        item.setEquipament(this.equipamentService.findEquipamentById(itemDto.getEquipament()));
        this.service.addNewItemToContract(contractId, item);
        return new ResponseEntity<>(HttpStatus.OK);
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
     * @param contractId
     * @param itemIndex
     */
    @DeleteMapping("/{contractId}/{itemIndex}")
    public ResponseEntity<?> removeItemContract(@PathVariable Long contractId,@PathVariable int itemIndex){
        this.service.removeItemContract(contractId,itemIndex);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * Update contract
     * @param contractId
     * @return
     */
    @PutMapping("/{contractId}")
    public ResponseEntity<ContractResponseDto> updateContract(@PathVariable Long contractId,
                                                              @RequestBody ContractUpdateDto contractUpdateDto){
       Contract contract = this.mapper.toContract(contractUpdateDto);
     return new ResponseEntity<ContractResponseDto>(
             this.mapper.toContractResponseDto(
                     this.service.updateContract(contractId, contract, contractUpdateDto.getClientId())), HttpStatus.OK);


    }

    /**
     * update a item of contract
     * @param contractId
     * @param itemIndex
     * @return
     */
    @PutMapping("/{contractId}/{itemIndex}")
    public ResponseEntity<ContractResponseDto> updateItemContract(@PathVariable Long contractId,
                                                                  @PathVariable int itemIndex,
                                                                  @RequestBody ItemContractCreateDto itemDto){
        ItemContract item = this.itemContractMapper.toItemContract(itemDto);
        item.setResidue(this.residueService.findById(itemDto.getResidue()));
        item.setEquipament(this.equipamentService.findEquipamentById(itemDto.getEquipament()));
        return new ResponseEntity<ContractResponseDto>(
        this.mapper.toContractResponseDto(this.service.updateItemContract(contractId,itemIndex,item)),HttpStatus.OK) ;

    }



}
