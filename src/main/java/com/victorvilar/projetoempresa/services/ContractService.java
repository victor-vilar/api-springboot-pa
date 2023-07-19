package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.controllers.dto.contract.ContractCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ContractResponseDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ItemContractCreateDto;
import com.victorvilar.projetoempresa.domain.customer.Customer;
import com.victorvilar.projetoempresa.exceptions.CustomerNotFoundException;
import com.victorvilar.projetoempresa.exceptions.ContractNotFoundException;
import com.victorvilar.projetoempresa.domain.customer.Contract;
import com.victorvilar.projetoempresa.domain.customer.ItemContract;
import com.victorvilar.projetoempresa.exceptions.ItemContractNotFoundException;
import com.victorvilar.projetoempresa.mappers.ContractMapper;
import com.victorvilar.projetoempresa.mappers.ItemContractMapper;
import com.victorvilar.projetoempresa.repository.ContractRepository;
import com.victorvilar.projetoempresa.repository.ItemContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class ContractService {

    private final ContractRepository contractRepository;
    private final CustomerService customerService;
    private final ItemContractRepository itemContractRepository;
    private final ContractMapper contractMapper;
    private final ItemContractMapper itemContractMapper;

    @Autowired
    public ContractService (ContractRepository repository,
                            CustomerService customerService,
                            ItemContractRepository itemContractRepository,
                            ContractMapper contractMapper,
                            ItemContractMapper itemContractMapper){
        this.contractRepository = repository;
        this.customerService = customerService;
        this.itemContractRepository = itemContractRepository;
        this.contractMapper = contractMapper;
        this.itemContractMapper = itemContractMapper;
    }

    /**
     * get all contracts
     * @return
     */
    public List<ContractResponseDto> getAllContracts() {

        return this.contractMapper.toContractResponsDtoList(this.contractRepository.findAll());
    }

    /**
     * get all contracts by client id
     * @param clientId
     * @return
     */
    public List<ContractResponseDto> getAllContractsByClientId(String clientId){
        return this.contractMapper.toContractResponsDtoList(contractRepository.findByCustomerCpfCnpj(clientId));
    }

    /**
     * get contract by id
     * @param id of a contract
     * @return a contract
     * @throws ContractNotFoundException
     */
    public ContractResponseDto getContractById(Long id) throws ContractNotFoundException{
        Contract contract = this.contractRepository.findById(id).orElseThrow(() -> new ContractNotFoundException("This contract doesn't exist") );
        return this.contractMapper.toContractResponseDto(contract);
    }

    private Contract findContractByid(Long id) throws ContractNotFoundException{
        Contract contract = this.contractRepository.findById(id).orElseThrow(() -> new ContractNotFoundException("This contract doesn't exist") );
        return contract;
    }

    /**
     * creates a new contract
     * @throws CustomerNotFoundException
     */
    @Transactional
    public ContractResponseDto save(ContractCreateDto contract) {

        //contractCreateDto to Contract
        Contract contract1 = this.contractMapper.toContract(contract);

        //find customer by id
        Customer customer = this.customerService.findCustomerById(contract.getCustomerId());

        //setting customer
        contract1.setCustomer(customer);

        //transform itemContractCreateList into a ItemContractList and add to contract
        this.itemContractMapper.fromItemContractCreateDtoListToItemContractList(
                        contract.getItens())
                .stream()
                .forEach(item -> contract1.addNewItem(item));

        return this.contractMapper.toContractResponseDto(this.contractRepository.save(contract1));
    }

    /**
     * add a new item to a contract
     * @param contractId
     */
    @Transactional
    public ContractResponseDto addNewItemToContract(Long contractId, ItemContractCreateDto itemDto) {

        ItemContract item = this.itemContractMapper.toItemContract(itemDto);
        Contract contract = this.findContractByid(contractId);
        contract.addNewItem(item);
        this.itemContractRepository.save(item);
        this.contractRepository.save(contract);
        return this.contractMapper.toContractResponseDto(contract);
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
     * @param itemId id of the item
     */
    @Transactional
    public Contract removeItemContract( Long itemId) {
        ItemContract item = this.itemContractRepository.findById(itemId).orElseThrow(()-> new ItemContractNotFoundException("This item doesn't exist"));
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
        contractToUpdate.setCustomer(this.customerService.findCustomerById(contract.getCustomer().getCpfCnpj()));
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
        ItemContract itemToUpdate = this.itemContractRepository.findById(item.getId()).orElseThrow(() -> new ItemContractNotFoundException("Item not found"));
        itemToUpdate.setEquipament(item.getEquipament());
        itemToUpdate.setResidue(item.getResidue());
        itemToUpdate.setQtdOfResidue(item.getQtdOfResidue());
        itemToUpdate.setValue(item.getValue());
        this.save(contract);
        return contract;
    }

}

