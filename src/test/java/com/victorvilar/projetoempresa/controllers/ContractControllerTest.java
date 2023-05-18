package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.domain.Contract;
import com.victorvilar.projetoempresa.mappers.ContractMapper;
import com.victorvilar.projetoempresa.mappers.ItemContractMapper;
import com.victorvilar.projetoempresa.services.ContractService;
import com.victorvilar.projetoempresa.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class ContractControllerTest {

    @InjectMocks
    private ContractController contractController;
    @Mock
    private  ContractService contractServiceMock;
    @Mock
    private  CustomerService customerServiceMock;
    @Mock
    private  ContractMapper mapperMock;
    @Mock
    private  ItemContractMapper itemContractMapperMock;


    @Test
    void getAllContracts() {

    }
}