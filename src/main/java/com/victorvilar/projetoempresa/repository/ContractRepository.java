package com.victorvilar.projetoempresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victorvilar.projetoempresa.model.Contract;

public interface ContractRepository extends JpaRepository<Contract,Long> {

}
