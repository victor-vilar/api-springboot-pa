package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.exceptions.CustomerNotFoundException;
import com.victorvilar.projetoempresa.exceptions.ContractNotFoundException;
import com.victorvilar.projetoempresa.domain.Contract;
import com.victorvilar.projetoempresa.domain.ItemContract;
import com.victorvilar.projetoempresa.exceptions.ItemContractNotFoundException;
import com.victorvilar.projetoempresa.exceptions.ItemNotFoundException;
import com.victorvilar.projetoempresa.repository.ContractRepository;
import com.victorvilar.projetoempresa.repository.ItemContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContractService {

    private final ContractRepository contractRepository;
    private final ClientService clientService;
    private final ItemContractRepository itemContractRepository;

    @Autowired
    public ContractService (ContractRepository repository,
                            ClientService clienteService,
                            ItemContractRepository itemContractRepository){
        this.contractRepository = repository;
        this.clientService = clienteService;
        this.itemContractRepository = itemContractRepository;
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
        return this.contractRepository.findByCustomerCpfCnpj(clientId);
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
     * @throws CustomerNotFoundException
     */
    @Transactional
    public Contract save(Contract contract) {
        return this.contractRepository.save(contract);
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
    public Contract removeItemContract( Long itemId) {
        ItemContract item = this.itemContractRepository.findById(itemId).orElseThrow(()-> new ItemContractNotFoundException("This item doesn't exist"))
        Contract contract = item.getContract();
        this.itemContractRepository.delete(item);
        this.save(contract);
        return contract;

    }

    /**
     * Update contract
     * @param contractId
     * @return
     */
    @Transactional
    public Contract updateContract(Long contractId, Contract contract){
        Contract contractToUpdate = this.getContractById(contractId);
        contractToUpdate.setCustomer(this.clientService.getClientById(contract.getCustomer().getCpfCnpj()));
        contractToUpdate.setNumber(contract.getNumber());
        contractToUpdate.setBeginDate(contract.getBeginDate());
        contractToUpdate.setEndDate(contract.getEndDate());
        this.save(contractToUpdate);
        return contractToUpdate;
    }

    /**
     * update a item of contract
     * @return
     */
    @Transactional
    public Contract updateItemContract(Contract contract, ItemContract item){
        ItemContract itemToUpdate = this.itemContractRepository.findById(item.getId()).orElseThrow(() -> new RuntimeException("erro"));
        itemToUpdate.setEquipament(item.getEquipament());
        itemToUpdate.setResidue(item.getResidue());
        itemToUpdate.setQtdOfResidue(item.getQtdOfResidue());
        itemToUpdate.setValue(item.getValue());
        this.save(contract);
        return contract;
    }

}

