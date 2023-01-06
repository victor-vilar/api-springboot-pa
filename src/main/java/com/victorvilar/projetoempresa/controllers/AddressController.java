package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.adress.AddressCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.adress.AddressResponseDto;
import com.victorvilar.projetoempresa.domain.Address;
import com.victorvilar.projetoempresa.domain.Client;
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

    private final AddressService service;
    private final AddressMapper mapper;
    private final ClientService clientService;

    @Autowired
    public AddressController(AddressService service,
                             AddressMapper mapper,
                             ClientService clientService){
        this.service = service;
        this.mapper = mapper;
        this.clientService=clientService;
    }

    /**
     * get all address
     * @return list of address
     */
    @GetMapping()
    public ResponseEntity<List<AddressResponseDto>> getAllAddress(){
     return new ResponseEntity<List<AddressResponseDto>>(
             this.mapper.toAddressResponseDtoList(this.service.getAllAddress())
             ,HttpStatus.FOUND);
    }

    /**
     * get all address of a client
     * @param clientId id of a client
     * @return a list of address of a client
     */
    @GetMapping("by-client/{clientId}")
    public ResponseEntity<List<AddressResponseDto>> getAllAddressByClient(@PathVariable String clientId){
        return new ResponseEntity<List<AddressResponseDto>>(
                this.mapper.toAddressResponseDtoList(this.service.getAllAddressByClient(clientId))
                ,HttpStatus.FOUND);
    }

    /**
     * get an address by id
     * @param id
     * @return address
     */
    @GetMapping("/{id}")
    public ResponseEntity<AddressResponseDto> getAddressById(@PathVariable Long id){
        return new ResponseEntity<AddressResponseDto>(
                this.mapper.toAddressResponseDto(this.service.getAddressById(id)),HttpStatus.FOUND
        );
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

        Client client = this.clientService.getClientById(clientId);
        Address address = this.mapper.toAddress(addressCreateDto);
        client.addNewAddress(address);
        this.service.addNewAddress(address);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * delete an address
     * @param id of a address
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddressById(@PathVariable Long id){
        this.service.deleteAddressById(id);
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
     Address address = this.mapper.toAddress(addressCreateDto);
     return new ResponseEntity<>(this.mapper.toAddressResponseDto(this.service.updateAddress(id,address)),HttpStatus.OK);
    }

}
