package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.entities.Client;
import com.victorvilar.projetoempresa.entities.Contract;
import com.victorvilar.projetoempresa.entities.ItemContract;
import com.victorvilar.projetoempresa.exceptions.ClientNotFoundException;
import com.victorvilar.projetoempresa.repository.ClientRepository;
import com.victorvilar.projetoempresa.repository.ContractRepository;

import java.util.List;

public class ContractService {

    private final ContractRepository contractRepository;
    private final ClientRepository   clientRepository;

    public ContractService (ContractRepository repository, ClientRepository clienteRepository){
        this.contractRepository = repository;
        this.clientRepository = clienteRepository;
    }


    public List<Contract> getAllContracts() {
        return this.contractRepository.findAll();
    }

    public Contract getContractById(Long id) {
        return this.contractRepository.findById(id).orElse();
    }


    public void addNewContract(Long clientId, List<ItemContract> itens) {
        Client client = this.clientRepository.findById(clientId).orElseThrow(new ClientNotFoundException("This client doesn't exist"));
        Contract contract = new Contract();
        contract.setClient(client);
        contract.setNumber();
        contract.setValidity();



    }

    public void addNewItemToContract(Long contractId) {

    }
}

