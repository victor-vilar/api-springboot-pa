package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.dto.contract.ContractCreateDto;
import com.victorvilar.projetoempresa.dto.contract.ContractResponseDto;
import com.victorvilar.projetoempresa.dto.contract.ContractUpdateDto;
import com.victorvilar.projetoempresa.dto.contract.ItemContractCreateDto;
import com.victorvilar.projetoempresa.domain.Customer;
import com.victorvilar.projetoempresa.exceptions.CustomerNotFoundException;
import com.victorvilar.projetoempresa.exceptions.ContractNotFoundException;
import com.victorvilar.projetoempresa.domain.Contract;
import com.victorvilar.projetoempresa.domain.ItemContract;
import com.victorvilar.projetoempresa.exceptions.ItemContractNotFoundException;
import com.victorvilar.projetoempresa.mappers.ContractMapper;
import com.victorvilar.projetoempresa.mappers.ItemContractMapper;
import com.victorvilar.projetoempresa.repository.ContractRepository;
import com.victorvilar.projetoempresa.repository.CustomerRepository;
import com.victorvilar.projetoempresa.repository.ItemContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class ContractService {

    private final ContractRepository contractRepository;
    private final ItemContractRepository itemContractRepository;
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;
    private final ContractMapper contractMapper;
    private final ItemContractMapper itemContractMapper;

    @Autowired
    public ContractService (ContractRepository repository,
                            CustomerService customerService,
                            ItemContractRepository itemContractRepository,
                            ContractMapper contractMapper,
                            ItemContractMapper itemContractMapper,
                            CustomerRepository customerRepository){
        this.contractRepository = repository;
        this.customerService = customerService;
        this.itemContractRepository = itemContractRepository;
        this.contractMapper = contractMapper;
        this.itemContractMapper = itemContractMapper;
        this.customerRepository = customerRepository;
    }

    /**
     * get all contracts
     * @return
     */
    public List<ContractResponseDto> getAll() {

        return this.contractMapper.toContractResponseDtoList(this.contractRepository.findAll());
    }

    /**
     * get all contracts by client id
     * @param clientId
     * @return
     */
    public List<ContractResponseDto> getAllByCustomerId(String clientId){
        return this.contractMapper.toContractResponseDtoList(contractRepository.findByCustomerCpfCnpj(clientId));
    }

    /**
     * get contract by id
     * @param id of a contract
     * @return a contract
     * @throws ContractNotFoundException
     */
    public ContractResponseDto getById(Long id) throws ContractNotFoundException{
        Contract contract = this.contractRepository.findById(id).orElseThrow(() -> new ContractNotFoundException("This contract doesn't exist") );
        return this.contractMapper.toContractResponseDto(contract);
    }

    public Contract findByContractId(Long id) throws ContractNotFoundException{
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
        this.customerRepository.save(customer);
        return this.contractMapper.toContractResponseDto(this.contractRepository.save(contract1));
    }

    /**
     * add a new item to a contract
     * @param contractId
     */
    @Transactional
    public ContractResponseDto addNewItemToContract(Long contractId, ItemContractCreateDto itemDto) {

        ItemContract item = this.itemContractMapper.toItemContract(itemDto);
        Contract contract = this.findByContractId(contractId);
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
    public void delete(Long contractId ){
        this.contractRepository.deleteById(contractId);
    }

    /**
     * remove a item from a contract
     * @param itemId id of the item
     */
    @Transactional
    public ContractResponseDto deleteItemContract(Long itemId) {
        ItemContract item = this.itemContractRepository.findById(itemId).orElseThrow(()-> new ItemContractNotFoundException("This item doesn't exist"));
        Contract contract = item.getContract();
        this.itemContractRepository.delete(item);
        this.contractRepository.save(contract);
        return this.contractMapper.toContractResponseDto(contract);

    }

    /**
     * Update contract
     * @param contractId
     * @return
     */
    @Transactional
    public ContractResponseDto update(Long contractId, ContractUpdateDto contractUpdateDto){

        //creates instance of contract
        Contract contract = this.findByContractId(contractId);

        //updating contracting
        contract.setCustomer(this.customerService.findCustomerById(contractUpdateDto.getCustomerId()));
        contract.setNumber(contractUpdateDto.getNumber());
        contract.setBeginDate(contractUpdateDto.getBeginDate());
        contract.setEndDate(contractUpdateDto.getEndDate());

        //transform itemContractCreateList into a ItemContractList and add to contract
        List<ItemContract> lista = this.itemContractMapper.fromItemContractUpdateDtoListToItemContractList(contractUpdateDto.getItens());

        //loop to insert a new item or update an exist one
        lista.stream().forEach(item ->{
            if(item.getId() == null){
                contract.addNewItem(item);
            }else{
                updateItemContract(contract,item);
            }
            this.itemContractRepository.save(item);
        });

        this.contractRepository.save(contract);
        return this.contractMapper.toContractResponseDto(contract);
    }

    /**
     * update a item of contract
     * @return
     */
    @Transactional
    public void updateItemContract(Contract contract, ItemContract item){
        ItemContract itemToUpdate = this.itemContractRepository.findById(item.getId()).orElseThrow(() -> new ItemContractNotFoundException("Item not found"));
        itemToUpdate.setEquipament(item.getEquipament());
        itemToUpdate.setResidue(item.getResidue());
        itemToUpdate.setQtdOfResidue(item.getQtdOfResidue());
        itemToUpdate.setValue(item.getValue());
    }

}

