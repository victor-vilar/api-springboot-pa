package com.victorvilar.projetoempresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victorvilar.projetoempresa.model.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,String> {


    public Optional<Client> findByCpfCnpj(String cpfCnpj);
}
