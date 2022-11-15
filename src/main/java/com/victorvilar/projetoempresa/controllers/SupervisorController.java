package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.supervisor.SupervisorCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.supervisor.SupervisorResponseDto;
import com.victorvilar.projetoempresa.domain.Client;
import com.victorvilar.projetoempresa.domain.Supervisor;
import com.victorvilar.projetoempresa.services.ClientService;
import com.victorvilar.projetoempresa.services.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController {

    private final SupervisorService supervisorService;
    private final ClientService clientService;

    @Autowired
    public SupervisorController(SupervisorService supervisorService, ClientService clientService){
        this.supervisorService = supervisorService;
        this.clientService = clientService;
    }

    /**
     * Get all supervisors
     * @return return a list of supervisorResponseDTo
     */
    @GetMapping()
    public ResponseEntity<List<SupervisorResponseDto>> getAllSupervisors(){
        return null;
    }

    /**
     * Get supervisor by id
     * @param id of a supervisor
     * @return ResponseEntity of SupervisorResponseDto
     */
    @GetMapping("/{supervisorId}")
    public ResponseEntity<?> getSupervisorById(@PathVariable Long id){
        return null;
    }

    /**
     * get all supervisor of a client
     * @param clientId id of a client
     * @return a list of SupervisorResponseDto of the client
     */
    @GetMapping("/{clientId}")
    public ResponseEntity<?> getSupervisorByClient(@PathVariable String clientId){
        return null;
    }

    /**
     * Add a new supervisor for a client
     * @param clientId string that represent the id of a client
     * @return http response
     */
    @PostMapping("/{clientId}")
    public ResponseEntity<?> addNewSupervisor(@PathVariable String clientId, @RequestBody SupervisorCreateDto supervisoCreateDto){
        Client client = this.clientService.getClientById(clientId);
        Supervisor supervisor = supervisoCreateDto.toSupervisor();
        supervisor.setClient(client);
        this.supervisorService.addNewSupervisor(supervisor);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
