package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.exceptions.ClientNotFoundException;
import com.victorvilar.projetoempresa.exceptions.ContractNotFoundException;
import com.victorvilar.projetoempresa.domain.Client;
import com.victorvilar.projetoempresa.domain.Contract;
import com.victorvilar.projetoempresa.domain.ItemContract;
import com.victorvilar.projetoempresa.repository.ClientRepository;
import com.victorvilar.projetoempresa.repository.ContractRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public Contract getContractById(Long id) throws ContractNotFoundException{
        return this.contractRepository.findById(id).orElseThrow(() -> new ContractNotFoundException("This contract doesn't exist") );
    }


    public void addNewContract(String clientId, List<ItemContract> itens) throws ClientNotFoundException {
        Client client = this.clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException("This client doesn't exist"));
        Contract contract = new Contract();
        contract.setClient(client);

        //TODO -> FIGURE OUT HOW TO GET THIS INFORMATION
        //contract.setNumber();
        //contract.setValidity();



    }

    public void addNewItemToContract(String contractId) {

    }
}

