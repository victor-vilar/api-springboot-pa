package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.controllers.dto.adress.AddressCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.adress.AddressResponseDto;
import com.victorvilar.projetoempresa.domain.customer.Address;
import com.victorvilar.projetoempresa.domain.customer.Customer;
import com.victorvilar.projetoempresa.exceptions.AddressNotFoundException;
import com.victorvilar.projetoempresa.mappers.AddressMapper;
import com.victorvilar.projetoempresa.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final CustomerService customerService;

    @Autowired
    //constructor
    public AddressService(AddressRepository addressRepository, AddressMapper mapper, CustomerService customerService) {
        this.addressRepository = addressRepository;
        this.addressMapper = mapper;
        this.customerService = customerService;
    }
    //------------

    /**
     * get all address
     * @return all address
     */
    public List<AddressResponseDto> getAllAddress(){
        return this.addressMapper.toAddressResponseDtoList(this.addressRepository.findAll());
    }

    /**
     *  get all address of a client
     * @param clientId
     * @return
     */
    public List<AddressResponseDto> getAllAddressByCustomer(String clientId){
        return this.addressMapper.toAddressResponseDtoList(this.addressRepository.findByCustomerCpfCnpj(clientId));
    }

    /**
     * get a Address Object without mapping
     * @return Address Object
     */
    private Address findAddressById(Long id){
        return this.addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException("This address doesn't exist"));
    }

    /**
     * get an address by id
     * @param id
     * @return
     */
    public AddressResponseDto getAddressById(Long id){
        return this.addressMapper.toAddressResponseDto(this.findAddressById(id));
    }

    /**
     * create a new address
     * @param addressCreateDto
     */
    public AddressResponseDto addNewAddress(AddressCreateDto addressCreateDto){
        Address address = this.addressMapper.toAddress(addressCreateDto);
        Customer customer = this.customerService.findCustomerById(addressCreateDto.getCustomerId());
        address.setClient(customer);
        return this.addressMapper.toAddressResponseDto(this.addressRepository.save(address));
    }


    /**
     * delete an address
     * @param id
     */
    public void deleteAddressById(Long id){
        Address address = this.findAddressById(id);
        this.addressRepository.deleteById(id);
    }


    /**
     * update an address
     * @param id
     * @param addressCreateDto
     * @return saved contract
     */
    public AddressResponseDto updateAddress(Long id, AddressCreateDto addressCreateDto){
        Address addressToUpdate = this.findAddressById(id);
        addressToUpdate.setAddressName(addressCreateDto.getAddressName());
        addressToUpdate.setAddressNumber(addressCreateDto.getAddressNumber());
        addressToUpdate.setCity(addressCreateDto.getCity());
        addressToUpdate.setComplement(addressCreateDto.getComplement());
        addressToUpdate.setState(addressCreateDto.getState());
        addressToUpdate.setZipCode(addressCreateDto.getZipCode());
        addressToUpdate.setRequiresCollection(addressCreateDto.isRequiresCollection());
        this.addressRepository.save(addressToUpdate);
        return this.addressMapper.toAddressResponseDto(addressToUpdate);
    }



}

