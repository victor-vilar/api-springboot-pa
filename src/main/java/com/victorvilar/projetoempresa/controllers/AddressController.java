package com.victorvilar.projetoempresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Address controller
 * @author Victor Vilar
 * @since 05/01/2023
 */

@RestController
@RequestMapping("/address")
public class AddressController {

    public AddressService service;

    @Autowired
    public AddressController(AddressService service){
        this.service = service;
    }

    /**
     * get all address
     * @return list of address
     */
    @GetMapping()
    public ResponseEntity<List<AddressResponseDto>> getAllAddress(){
        return null;
    }

    /**
     * get all address of a client
     * @param clientId id of a client
     * @return a list of address of a client
     */
    @GetMapping("by-client/{clientId}")
    public ResponseEntity<List<AddressResponseDto>> getAllAddressByClient(@PathVariable String clientId){
        return null;
    }

    /**
     * get a address by id
     * @param id
     * @return address
     */
    @GetMapping("/{id}")
    public ResponseEntity<AddressResponseDto> getAddressById(@PathVariable Long id){
        return null;
    }

    /**
     *  create a new addresss
     * @param addressCreateDto address body to save
     * @param clientId client of that address
     * @return saved address
     */
    @PostMapping("/{clientId}")
    public ResponseEntity<?> addNewAddress(@RequestBody AddressCreateDto addressCreateDto,
                                          @PathVariable String clientId){
        return null;
    }

    /**
     * delete a address
     * @param id of a address
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddressById(@PathVariable Long id){
        return null;
    }

    /**
     * update a address
     * @param id id of a address
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<AddressResponseDto> updateAddress(@PathVariable Long id){
        return null;
    }

}
