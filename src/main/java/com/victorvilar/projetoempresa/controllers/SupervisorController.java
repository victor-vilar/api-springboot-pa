package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.model.Supervisor;
import com.victorvilar.projetoempresa.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController {

    private SupervisorRepository supervisorRepository;

    @Autowired
    public SupervisorController(SupervisorRepository supervisorRepository){
        this.supervisorRepository = supervisorRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Supervisor>> getAllSupervisors(){
        return null;
    }

    @GetMapping("/{supervisorId}")
    public ResponseEntity<?> getSupervisorById(@PathVariable Long id){
        return null;
    }

    @GetMapping("{}/{}")
    public ResponseEntity<?> getSupervisorByClient(@PathVariable String clientId){
        return null;
    }
}
