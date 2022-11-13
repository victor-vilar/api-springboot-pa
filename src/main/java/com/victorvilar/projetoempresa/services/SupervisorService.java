package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.model.Supervisor;
import com.victorvilar.projetoempresa.repository.SupervisorRepository;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
