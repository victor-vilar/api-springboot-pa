package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.adress.AddressCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.adress.AddressResponseDto;
import com.victorvilar.projetoempresa.domain.Address;
import com.victorvilar.projetoempresa.domain.Customer;
import com.victorvilar.projetoempresa.mappers.AddressMapper;
import com.victorvilar.projetoempresa.services.AddressService;
import com.victorvilar.projetoempresa.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private final AddressMapper addressMapper;
    private final ClientService clientService;

    @Autowired
    public AddressController(AddressService service, AddressMapper mapper,ClientService clientService){
        this.addressService = service;
        this.addressMapper = mapper;
        this.clientService = clientService;
    }

    /**
     * get all address
     * @return list of address
     */
    @GetMapping()
    public ResponseEntity<List<AddressResponseDto>> getAllAddress(){
        return new ResponseEntity<List<AddressResponseDto>>(this.addressMapper.toAddressResponseDtoList(
                this.addressService.getAllAddress()), HttpStatus.OK);
    }

    /**
     * get all address of a client
     * @param clientId id of a client
     * @return a list of address of a client
     */
    @GetMapping("by-customer/{clientId}")
    public ResponseEntity<List<AddressResponseDto>> getAllAddressByClient(@PathVariable String clientId){
        return new ResponseEntity<List<AddressResponseDto>>(this.addressMapper.toAddressResponseDtoList(
                this.addressService.getAllAddressByClient(clientId)), HttpStatus.OK);

    }

    /**
     * get an address by id
     * @param id
     * @return address
     */
    @GetMapping("/{id}")
    public ResponseEntity<AddressResponseDto> getAddressById(@PathVariable Long id){

       return new ResponseEntity<AddressResponseDto>(
               this.addressMapper.toAddressResponseDto(
                       this.addressService.getAddressById(id)
               )
       ,HttpStatus.OK);

    }

    /**
     *  create a new addresss
     * @param addressCreateDto address body to save
     * @param clientId client of that address
     * @return saved address
     */
    @PostMapping("/{clientId}")
    public ResponseEntity<AddressResponseDto> addNewAddress(@RequestBody AddressCreateDto addressCreateDto,
                                          @PathVariable String clientId){

        Address address = this.addressMapper.toAddress(addressCreateDto);
        Customer customer = this.clientService.getClientById(clientId);
        customer.addNewAddress(address);
        this.addressService.addNewAddress(address);

        return new ResponseEntity<AddressResponseDto>(this.addressMapper.toAddressResponseDto(address),HttpStatus.OK);
    }

    /**
     * delete an address
     * @param id of a address
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
        Address address = this.addressMapper.toAddress(addressCreateDto);
        return new ResponseEntity<AddressResponseDto>(
                this.addressMapper.toAddressResponseDto(
                    this.addressService.updateAddress(id, address)),HttpStatus.OK);


    }

}
