package com.victorvilar.projetoempresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victorvilar.projetoempresa.model.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
