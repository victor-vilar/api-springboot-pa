package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.supervisor.SupervisorCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.supervisor.SupervisorResponseDto;
import com.victorvilar.projetoempresa.domain.Client;
import com.victorvilar.projetoempresa.domain.Supervisor;
import com.victorvilar.projetoempresa.mappers.SupervisorMapper;
import com.victorvilar.projetoempresa.services.ClientService;
import com.victorvilar.projetoempresa.services.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController {

    private final SupervisorService supervisorService;
    private final ClientService clientService;
    private final SupervisorMapper mapper;

    @Autowired
    public SupervisorController(SupervisorService supervisorService,
                                ClientService clientService,
                                SupervisorMapper mapper){
        this.supervisorService = supervisorService;
        this.clientService = clientService;
        this.mapper = mapper;
    }

    /**
     * Get all supervisors
     * @return return a list of supervisorResponseDTo
     */
    @GetMapping()
    public ResponseEntity<List<SupervisorResponseDto>> getAllSupervisors(){
        return new ResponseEntity<List<SupervisorResponseDto>>(
                this.mapper.toSupervisorResponseDtoList(
                        this.supervisorService.getAllSupervisors()
                ),HttpStatus.OK);
    }

    /**
     * get all supervisores by client id
      * @param clientId client id
     * @return list of supervisores of that client
     */
    @GetMapping("by-client/{clientId}")
    public ResponseEntity<?> getAllSupervisorsByClient(@PathVariable String clientId){
        Client client = this.clientService.getClientById(clientId);
        return new ResponseEntity<>( this.mapper.toSupervisorResponseDtoList(
                this.supervisorService.findAllByClientId(clientId)
        ),HttpStatus.FOUND);
    }

    /**
     * Get supervisor by id
     * @param id of a supervisor
     * @return ResponseEntity of SupervisorResponseDto
     */
    @GetMapping("/{supervisorId}")
    public ResponseEntity<SupervisorResponseDto> getSupervisorById(@PathVariable Long id){
        return new ResponseEntity<SupervisorResponseDto>(
                mapper.toSupervisorResponseDto(
                        this.supervisorService.findSupervisorById(id)),HttpStatus.FOUND);
    }


    /**
     * Add a new supervisor for a client
     * @param clientId string that represent the id of a client
     * @return http response
     */
    @PostMapping("/{clientId}")
    public ResponseEntity<?> addNewSupervisor(@PathVariable String clientId, @Valid  @RequestBody SupervisorCreateDto supervisoCreateDto){
        Client client = this.clientService.getClientById(clientId);
        Supervisor supervisor = mapper.toSupervisor(supervisoCreateDto);
        client.addNewSupervisor(supervisor);
        //supervisor.setClient(client);
        this.supervisorService.addNewSupervisor(supervisor);
        return new ResponseEntity<>(HttpStatus.CREATED);
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
