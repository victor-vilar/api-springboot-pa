package com.victorvilar.projetoempresa.repository;

import com.victorvilar.projetoempresa.domain.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Test for supervisor repository")
class SupervisorRepositoryTest {

    @Autowired
    private SupervisorRepository supervisorRepository;

    @Test
     void test(){

    }

//    private Customer createCustomer(){
//        Customer customer = new Customer();
//    }
}