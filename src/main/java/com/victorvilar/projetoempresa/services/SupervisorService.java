package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.domain.Supervisor;
import com.victorvilar.projetoempresa.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervisorService {

    private final SupervisorRepository supervisorRespository;

    @Autowired
    public SupervisorService(SupervisorRepository supervisorRepository){
        this.supervisorRespository = supervisorRepository;
    }

    /**
     * add a new supervisor for a client
     * @param supervisor
     */
    public void addNewSupervisor(Supervisor supervisor){
        this.supervisorRespository.save(supervisor);
    }

    public List<Supervisor> getAllSupervisors() {
        return this.supervisorRespository.findAll();
    }

    public List<Supervisor> findAllByClientId(String clientId) {
        return this.supervisorRespository.findByClientCpfCnpj(clientId);
    }
}
