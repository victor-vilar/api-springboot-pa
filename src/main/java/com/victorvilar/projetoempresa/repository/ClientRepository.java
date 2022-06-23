package com.victorvilar.projetoempresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victorvilar.projetoempresa.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
