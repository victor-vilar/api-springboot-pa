package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.adress.AddressCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.adress.AddressResponseDto;
import com.victorvilar.projetoempresa.domain.Address;
import com.victorvilar.projetoempresa.mappers.AddressMapper;
import com.victorvilar.projetoempresa.services.AddressService;
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

    public AddressService addressService;
    public AddressMapper addressMapper;

    @Autowired
    public AddressController(AddressService service, AddressMapper mapper){
        this.addressService = service;
        this.addressMapper = mapper;
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
    @GetMapping("by-client/{clientId}")
    public ResponseEntity<List<AddressResponseDto>> getAllAddressByClient(@PathVariable String clientId){
        return null;
    }

    /**
     * get an address by id
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
     * delete an address
     * @param id of a address
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddressById(@PathVariable Long id){
        return null;
    }

    /**
     * update an address
     * @param id id of a address
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<AddressResponseDto> updateAddress(@PathVariable Long id,
                                                            @RequestBody AddressCreateDto addressCreateDto){
        return null;
    }

}
