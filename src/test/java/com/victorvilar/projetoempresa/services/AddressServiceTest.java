package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.domain.customer.Address;
import com.victorvilar.projetoempresa.domain.customer.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Contract service tests class")
class AddressServiceTest {

    Customer customer;
    Customer anotherCustomer;
    Address address;

    @BeforeEach
    void setUp() {

        customer = new Customer.CustomerBuilder()
                .cpfCnpj("59213337000")
                .nameCompanyName("TEST CUSTOMER")
                .build();

        anotherCustomer = new Customer.CustomerBuilder()
                .cpfCnpj("40204340004")
                .nameCompanyName("TEST CUSTOMER")
                .build();

        
    }
}