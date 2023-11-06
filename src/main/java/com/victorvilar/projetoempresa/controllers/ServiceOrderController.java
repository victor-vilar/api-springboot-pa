package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.dto.serviceorder.ServiceOrderCreateDto;
import com.victorvilar.projetoempresa.dto.serviceorder.ServiceOrderResponseDto;
import com.victorvilar.projetoempresa.dto.serviceorder.ServiceOrderUpdateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-order")
public class ServiceOrderController implements SystemController<ServiceOrderCreateDto,ServiceOrderUpdateDto, ServiceOrderResponseDto>{


    @Override
    public ResponseEntity<List<ServiceOrderResponseDto>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<List<ServiceOrderResponseDto>> getAllByCustomerId(String customerId) {
        return null;
    }

    @Override
    public ResponseEntity<ServiceOrderResponseDto> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ServiceOrderResponseDto> save(ServiceOrderCreateDto createDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ServiceOrderResponseDto> update(ServiceOrderUpdateDto updateDto) {
        return null;
    }
}
