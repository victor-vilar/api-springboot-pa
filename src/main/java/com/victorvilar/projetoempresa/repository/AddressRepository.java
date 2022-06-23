package com.victorvilar.projetoempresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victorvilar.projetoempresa.embendable.AddressId;
import com.victorvilar.projetoempresa.entities.Address;

public interface AddressRepository extends JpaRepository<Address,AddressId> {

}
