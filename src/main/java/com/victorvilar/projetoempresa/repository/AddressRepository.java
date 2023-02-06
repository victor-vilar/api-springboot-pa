package com.victorvilar.projetoempresa.repository;

import com.victorvilar.projetoempresa.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import com.victorvilar.projetoempresa.embendable.AddressId;
import com.victorvilar.projetoempresa.domain.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {

    List<Address> findByCustomerCpfCnpj(String clientId);
}
