package com.victorvilar.projetoempresa.repository;

import com.victorvilar.projetoempresa.domain.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.victorvilar.projetoempresa.domain.Contract;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract,Long> {

    List<Contract> findByClientCpfCnpj(String clientId);
}
