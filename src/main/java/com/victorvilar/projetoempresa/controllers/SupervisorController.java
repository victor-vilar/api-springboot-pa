package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.supervisor.SupervisorCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.supervisor.SupervisorResponseDto;
import com.victorvilar.projetoempresa.domain.customer.Customer;
import com.victorvilar.projetoempresa.domain.customer.Supervisor;
import com.victorvilar.projetoempresa.mappers.SupervisorMapper;
import com.victorvilar.projetoempresa.services.CustomerService;
import com.victorvilar.projetoempresa.services.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController {

    private final SupervisorService supervisorService;
    private final CustomerService customerService;
    private final SupervisorMapper mapper;

    @Autowired
    public SupervisorController(SupervisorService supervisorService,
                                CustomerService customerService,
                                SupervisorMapper mapper){
        this.supervisorService = supervisorService;
        this.customerService = customerService;
        this.mapper = mapper;
    }

    /**
     * Get all supervisors
     * @return return a list of supervisorResponseDTo
     */
    @GetMapping()
    public ResponseEntity<List<SupervisorResponseDto>> getAllSupervisors(){
        return ResponseEntity.ok(this.supervisorService.getAllSupervisors());
    }

    /**
     * get all supervisores by client id
      * @param customerId client id
     * @return list of supervisores of that client
     */
    @GetMapping("by-customer/{clientId}")
    public ResponseEntity<List<SupervisorResponseDto>> getAllSupervisorsByClient(@PathVariable String customerId){
        return ResponseEntity.ok(this.supervisorService.getAllByCustomerCpfCnpj(customerId));
    }

    /**
     * Get supervisor by id
     * @param id of a supervisor
     * @return ResponseEntity of SupervisorResponseDto
     */
    @GetMapping("/{supervisorId}")
    public ResponseEntity<SupervisorResponseDto> getSupervisorById(@PathVariable Long id){
        return ResponseEntity.ok(this.supervisorService.getSupervisorById(id));
    }

    /**
     * Add a new supervisor for a client
     * @return http response
     */
    @PostMapping()
    public ResponseEntity<SupervisorResponseDto> addNewSupervisor(@Valid  @RequestBody SupervisorCreateDto supervisoCreateDto){
        Customer customer = this.customerService.findCustomerById(supervisoCreateDto.getCustomerId());
        Supervisor supervisor = mapper.toSupervisor(supervisoCreateDto);
        customer.addNewSupervisor(supervisor);
        return new ResponseEntity<SupervisorResponseDto>(
                this.mapper.toSupervisorResponseDto(this.supervisorService.addNewSupervisor(supervisor)),
                HttpStatus.CREATED);
    }


    @DeleteMapping("{supervisorId}")
    public ResponseEntity<Void> deleteSupervisor(@PathVariable Long supervisorId){
        this.supervisorService.deleteById(supervisorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{supervisorId}")
    public ResponseEntity<SupervisorResponseDto> updateSupervisor(@Valid @PathVariable Long supervisorId,
                                                                  @RequestBody SupervisorCreateDto supervisorCreateDto){
        Supervisor supervisor = mapper.toSupervisor(supervisorCreateDto);
        return new ResponseEntity<SupervisorResponseDto>(
                mapper.toSupervisorResponseDto(
                        this.supervisorService.updateSupervisor(supervisor, supervisorId)),HttpStatus.OK);

    }

}
