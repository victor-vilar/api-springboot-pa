package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.dto.serviceorder.ServiceOrderCreateDto;
import com.victorvilar.projetoempresa.dto.serviceorder.ServiceOrderUpdateDto;
import com.victorvilar.projetoempresa.mappers.ServiceOrderMapper;
import com.victorvilar.projetoempresa.repository.ServiceOrderRepository;
import com.victorvilar.projetoempresa.services.interfaces.EntityOfCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOrderService implements EntityOfCustomerService<ServiceOrderCreateDto, ServiceOrderUpdateDto,ServiceOrderUpdateDto> {


    private final ServiceOrderRepository serviceOrderRepository;
    private final ServiceOrderMapper mapper;

    @Autowired
    public ServiceOrderService(ServiceOrderRepository repository, ServiceOrderMapper mapper){
        this.serviceOrderRepository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<ServiceOrderUpdateDto> getAllByCustomerId(String customerId) {
        return null;
    }

    @Override
    public List<ServiceOrderUpdateDto> getAll() {
        return null;
    }

    @Override
    public ServiceOrderUpdateDto getById(Long id) {
        return null;
    }

    @Override
    public ServiceOrderUpdateDto save(ServiceOrderCreateDto createDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ServiceOrderUpdateDto update(ServiceOrderUpdateDto updateDto) {
        return null;
    }
}
