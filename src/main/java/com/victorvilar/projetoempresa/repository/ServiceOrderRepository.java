package com.victorvilar.projetoempresa.repository;

import com.victorvilar.projetoempresa.domain.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
}
