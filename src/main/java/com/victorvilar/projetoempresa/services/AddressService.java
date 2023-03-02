package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.domain.Address;
import com.victorvilar.projetoempresa.exceptions.AddressNotFoundException;
import com.victorvilar.projetoempresa.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    //constructor
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    //------------

    /**
     * get all address
     * @return all address
     */
    public List<Address> getAllAddress(){
        return this.addressRepository.findAll();
    }

    /**
     *  get all address of a client
     * @param clientId
     * @return
     */
    public List<Address> getAllAddressByClient(String clientId){
        return this.addressRepository.findByCustomerCpfCnpj(clientId);
    }

    /**
     * get an address by id
     * @param id
     * @return
     */
    public Address getAddressById(Long id){
        return this.addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException("This address doesn't exist"));
    }

    /**
     * create a new address
     * @param address
     */
    public void addNewAddress(Address address){
        this.addressRepository.save(address);
    }


    /**
     * delete an address
     * @param id
     */
    public void deleteAddressById(Long id){
        Address address = this.getAddressById(id);
        this.addressRepository.deleteById(id);
    }


    /**
     * update an address
     * @param id
     * @param address
     * @return
     */
    public Address updateAddress(Long id, Address address){
        Address addressToUpdate = this.getAddressById(id);
        addressToUpdate.setAddressName(address.getAddressName());
        addressToUpdate.setAddressNumber(address.getAddressNumber());
        addressToUpdate.setCity(address.getCity());
        addressToUpdate.setComplement(address.getComplement());
        addressToUpdate.setState(address.getState());
        addressToUpdate.setZipCode(address.getZipCode());
        addressToUpdate.setRequiresCollection(address.isRequiresCollection());
        this.addressRepository.save(addressToUpdate);
        return addressToUpdate;
    }
}
