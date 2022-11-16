package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.domain.Supervisor;
import com.victorvilar.projetoempresa.exceptions.SupervisorNotFoundException;
import com.victorvilar.projetoempresa.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional
    public void addNewSupervisor(Supervisor supervisor){
        this.supervisorRespository.save(supervisor);
    }


    /**
     * find supervisor by id
     * @param id id of supervisor
     * @return
     */
    public Supervisor findSupervisorById(Long id){
       return this.supervisorRespository.findById(id).orElseThrow(() -> new SupervisorNotFoundException("This user doesn't exist"));
    }


    /**
     * get all supervisors
     * @return
     */
    public List<Supervisor> getAllSupervisors() {
        return this.supervisorRespository.findAll();
    }

    /**
     * get all supervisores of a client
     * @param clientId id of a client
     * @return
     */
    public List<Supervisor> findAllByClientId(String clientId) {
        return this.supervisorRespository.findByClientCpfCnpj(clientId);
    }

    /**
     * delete a supervisor
     * @param supervisorId supervisor id
     */
    @Transactional
    public void deleteById(Long supervisorId) {
        this.supervisorRespository.deleteById(supervisorId);
    }

    /**
     * Update supervisor data
     * @param supervisor supervisor created at controller that have the new data
     * @param supervisorId id of client to update
     */
    public Supervisor updateSupervisor(Supervisor supervisor, Long supervisorId) {
        Supervisor supervisorToUpdate = findSupervisorById(supervisorId);
        supervisorToUpdate.setName(supervisor.getName());
        supervisorToUpdate.setRole(supervisor.getRole());
        supervisorToUpdate.setEmail(supervisor.getEmail());
        supervisorToUpdate.setPhoneNumber(supervisor.getPhoneNumber());
        return this.supervisorRespository.save(supervisorToUpdate);
    }
}
