package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.applicationuser.ApplicationUserDto;
import com.victorvilar.projetoempresa.services.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application-user")
public class ApplicationUserController {


    private final ApplicationUserService service;

    @Autowired
    public ApplicationUserController(PasswordEncoder passwordEncoder, ApplicationUserService service){
        this.service = service;

    }


    @PostMapping("/register")
    public ResponseEntity<?> registerNewuser(@RequestBody ApplicationUserDto applicationUserDto){

        this.service.save(applicationUserDto);
        return ResponseEntity.ok("Salvo com sucesso");

    }
}
