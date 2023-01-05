package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.domain.Address;
import com.victorvilar.projetoempresa.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class AddressService {

    public AddressRepository addressRepository;

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
        //TODO ----------------->>
        return null;
    }

    /**
     *  get all address of a client
     * @param clientId
     * @return
     */
    public List<Address> getAllAddressByClient(String clientId){
        //TODO ----------------->>
        return null;
    }

    /**
     * get an address by id
     * @param id
     * @return
     */
    public Address getAddressById(Long id){
        //TODO ----------------->>
        return null;
    }


    /**
     * create a new address
     * @param clientId
     * @param address
     */
    public void addNewAddress(String clientId, Address address){
        //TODO ----------------->>
    }


    /**
     * delete an address
     * @param id
     */
    public void deleteAddressById(Long id){
        //TODO ----------------->>

    }


    /**
     * update an address
     * @param id
     * @param address
     * @return
     */
    public Address updateAddress(Long id, Address address){
        //TODO ----------------->>
        return null;
    }
}
