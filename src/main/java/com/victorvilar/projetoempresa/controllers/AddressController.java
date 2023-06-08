package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.adress.AddressCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.adress.AddressResponseDto;
import com.victorvilar.projetoempresa.domain.Address;
import com.victorvilar.projetoempresa.domain.Customer;
import com.victorvilar.projetoempresa.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Address controller
 * @author Victor Vilar
 * @since 05/01/2023
 */

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;


    @Autowired
    public AddressController(AddressService service){
        this.addressService = service;
    }

    /**
     * get all address
     * @return list of address
     */
    @GetMapping()
    public ResponseEntity<List<AddressResponseDto>> getAllAddress(){
        return ResponseEntity.status(HttpStatus.OK).body(this.addressService.getAllAddress());
    }

    /**
     * get all address of a client
     * @param clientId id of a client
     * @return a list of address of a client
     */
    @GetMapping("by-customer/{clientId}")
    public ResponseEntity<List<AddressResponseDto>> getAllAddressByCustomer(@PathVariable String clientId){
        return ResponseEntity.status(HttpStatus.OK).body(this.addressService.getAllAddressByCustomer(clientId));
    }

    /**
     * get an address by id
     * @param id
     * @return address
     */
    @GetMapping("/{id}")
    public ResponseEntity<AddressResponseDto> getAddressById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.addressService.getAddressById(id));
    }

    /**
     *  create a new addresss
     * @param addressCreateDto address body to save
     * @return saved address
     */
    @PostMapping()
    public ResponseEntity<AddressResponseDto> addNewAddress(@Valid @RequestBody AddressCreateDto addressCreateDto){
        return ResponseEntity.status(HttpStatus.OK).body(this.addressService.addNewAddress(addressCreateDto));
    }

    /**
     * delete an address
     * @param id of an address
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddressById(@PathVariable Long id){
        this.addressService.deleteAddressById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * update an address
     * @param id id of a address
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<AddressResponseDto> updateAddress(@PathVariable Long id,
                                                            @RequestBody AddressCreateDto addressCreateDto){

        return ResponseEntity.status(HttpStatus.OK).body(this.addressService.updateAddress(id,addressCreateDto));


    }

}
