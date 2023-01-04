package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.exceptions.ClientNotFoundException;
import com.victorvilar.projetoempresa.exceptions.ContractNotFoundException;
import com.victorvilar.projetoempresa.domain.Client;
import com.victorvilar.projetoempresa.domain.Contract;
import com.victorvilar.projetoempresa.domain.ItemContract;
import com.victorvilar.projetoempresa.exceptions.ItemNotFoundException;
import com.victorvilar.projetoempresa.repository.ClientRepository;
import com.victorvilar.projetoempresa.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContractService {

    private final ContractRepository contractRepository;
    private final ClientService clientService;

    @Autowired
    public ContractService (ContractRepository repository,
                            ClientService clienteService){
        this.contractRepository = repository;
        this.clientService = clienteService;
    }

    /**
     * get all contracts
     * @return
     */
    public List<Contract> getAllContracts() {
        return this.contractRepository.findAll();
    }

    /**
     * get all contracts by client id
     * @param clientId
     * @return
     */
    public List<Contract> getAllContractsByClientId(String clientId){
        return this.contractRepository.findByClientCpfCnpj(clientId);
    }

    /**
     * get contract by id
     * @param id of a contract
     * @return a contract
     * @throws ContractNotFoundException
     */
    public Contract getContractById(Long id) throws ContractNotFoundException{
        return this.contractRepository.findById(id).orElseThrow(() -> new ContractNotFoundException("This contract doesn't exist") );
    }

    /**
     * creates a new contract
     * @throws ClientNotFoundException
     */
    @Transactional
    public void save(Contract contract) {
        this.contractRepository.save(contract);
    }

    /**
     * add a new item to a contract
     * @param contractId
     */
    @Transactional
    public void addNewItemToContract(Long contractId, ItemContract item) {
        Contract contract = this.getContractById(contractId);
        contract.addNewItem(item);
        this.save(contract);
    }

    /**
     * remove a contract from db
     * @param contractId
     */
    @Transactional
    public void removeContract(Long contractId ){
        this.contractRepository.deleteById(contractId);
    }

    /**
     * remove a item from a contract
     * @param contractId
     * @param itemIndex
     */
    @Transactional
    public void removeItemContract(Long contractId, int itemIndex) {
        Contract contract = this.getContractById(contractId);
        if (itemIndex <= contract.getItens().size()) {
            contract.deleteItem(itemIndex);
            this.save(contract);
        } else {
            throw new ItemNotFoundException("This item doesn't exist");
        }
    }

    /**
     * Update contract
     * @param contractId
     * @return
     */
    @Transactional
    public Contract updateContract(Long contractId, Contract contract, String clienteId){
        Contract contractToUpdate = this.getContractById(contractId);
        contractToUpdate.setClient(this.clientService.getClientById(clienteId));
        contractToUpdate.setNumber(contract.getNumber());
        contractToUpdate.setBeginDate(contract.getBeginDate());
        contractToUpdate.setEndDate(contract.getEndDate());
        this.save(contractToUpdate);
        return contractToUpdate;
    }

    /**
     * update a item of contract
     * @param contractId
     * @param itemId
     * @return
     */
    @Transactional
    public Contract updateItemContract(Long contractId, Long itemId){
        //TODO ------------>
        return null;
    }

}

