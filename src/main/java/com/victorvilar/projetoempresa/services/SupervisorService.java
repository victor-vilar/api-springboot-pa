package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.controllers.dto.supervisor.SupervisorResponseDto;
import com.victorvilar.projetoempresa.domain.customer.Supervisor;
import com.victorvilar.projetoempresa.exceptions.SupervisorNotFoundException;
import com.victorvilar.projetoempresa.mappers.SupervisorMapper;
import com.victorvilar.projetoempresa.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class SupervisorService {

    private final SupervisorRepository supervisorRespository;
    private final CustomerService customerService;
    private final SupervisorMapper mapper;

    @Autowired
    public SupervisorService(SupervisorRepository supervisorRespository,
                             CustomerService customerService,
                             SupervisorMapper mapper){
        this.supervisorRespository = supervisorRespository;
        this.customerService = customerService;
        this.mapper = mapper;
    }

    /**
     * get all supervisors
     * @return
     */
    public List<SupervisorResponseDto> getAllSupervisors() {
        return this.mapper.toSupervisorResponseDtoList(this.supervisorRespository.findAll());
    }



    /**
     * add a new supervisor for a client
     * @param supervisor
     */
    @Transactional
    public Supervisor addNewSupervisor(Supervisor supervisor){
        this.supervisorRespository.save(supervisor);
        return supervisor;
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
     * get all supervisores of a client
     * @param clientId id of a client
     * @return
     */
    public List<Supervisor> findAllByClientId(String clientId) {
        return this.supervisorRespository.findByCustomerCpfCnpj(clientId);
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

    @Transactional
    public Supervisor updateSupervisor(Supervisor supervisor, Long supervisorId) {
        Supervisor supervisorToUpdate = findSupervisorById(supervisorId);
        supervisorToUpdate.setName(supervisor.getName());
        supervisorToUpdate.setRole(supervisor.getRole());
        supervisorToUpdate.setEmail(supervisor.getEmail());
        supervisorToUpdate.setPhoneNumber(supervisor.getPhoneNumber());
        return this.supervisorRespository.save(supervisorToUpdate);
    }
}
