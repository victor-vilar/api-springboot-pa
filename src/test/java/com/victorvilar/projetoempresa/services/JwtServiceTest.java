package com.victorvilar.projetoempresa.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Customer service tests class")
class JwtServiceTest {

    @InjectMocks
    private JwtService jwtService;




    @Test
    @DisplayName("generate a token")
    public void generateToken_WhenSuccessfull(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("username","teste");
        claims.put("role","testUser");
        String token = this.jwtService.generateJwtToken(claims);
        Assertions.assertNotNull(token);


    }

    @Test
    @DisplayName("validate a token")
    public void validateToken_WhenSuccessfull(){


    }


}