package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.entities.Contract;
import com.victorvilar.projetoempresa.entities.ItemContract;
import com.victorvilar.projetoempresa.repository.ClientRepository;
import com.victorvilar.projetoempresa.repository.ContractRepository;

import java.util.List;

public class ContractService {

    private final ContractRepository repository;

    public ContractService (ContractRepository repository){
        this.repository = repository;
    }


    public List<Contract> getAllContracts() {
        return repository.findAll();
    }

    public Contract getContractById(Long id) {
        return repository.findById(id).orElse();
    }


    public void addNewContract(Long clientId, List<ItemContract> itens) {

    }

    public void addNewItemToContract(Long contractId) {

    }
}

