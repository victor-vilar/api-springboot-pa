package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.exceptions.ClientNotFoundException;
import com.victorvilar.projetoempresa.exceptions.ContractNotFoundException;
import com.victorvilar.projetoempresa.domain.Client;
import com.victorvilar.projetoempresa.domain.Contract;
import com.victorvilar.projetoempresa.domain.ItemContract;
import com.victorvilar.projetoempresa.repository.ClientRepository;
import com.victorvilar.projetoempresa.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    private final ContractRepository contractRepository;
    private final ClientRepository   clientRepository;

    @Autowired
    public ContractService (ContractRepository repository, ClientRepository clienteRepository){
        this.contractRepository = repository;
        this.clientRepository = clienteRepository;
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
        //TODO ------------>
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
    public void addNewContract(String clientId) throws ClientNotFoundException {
        Client client = this.clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException("This client doesn't exist"));
        Contract contract = new Contract();
        contract.setClient(client);

        //TODO -> FIGURE OUT HOW TO GET THIS INFORMATION
        //contract.setNumber();
        //contract.setValidity();

    }

    /**
     * add a new item to a contract
     * @param contractId
     */
    public void addNewItemToContract(Long contractId) {
        //TODO ------------>
    }

    /**
     * remove a contract from db
     * @param contractId
     */
    public void removeContract(Long contractId ){
        //TODO ------------>
    }

    /**
     * remove a item from a contract
     * @param contractId
     * @param itemId
     */
    public void removeItemContract(Long contractId, Long itemId){
        //TODO ------------>
    }

    /**
     * Update contract
     * @param contractId
     * @return
     */
    public Contract updateContract(Long contractId){
        //TODO ------------>
    }

    /**
     * update a item of contract
     * @param contractId
     * @param itemId
     * @return
     */
    public Contract updateItemContract(Long contractId, Long itemId){
        //TODO ------------>
    }

}

