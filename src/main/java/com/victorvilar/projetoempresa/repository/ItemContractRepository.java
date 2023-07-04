package com.victorvilar.projetoempresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victorvilar.projetoempresa.domain.customer.ItemContract;

public interface ItemContractRepository extends JpaRepository<ItemContract,Long> {

}
