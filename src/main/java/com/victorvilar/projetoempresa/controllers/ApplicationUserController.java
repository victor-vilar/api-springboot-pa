package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.applicationuser.ApplicationUserCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ApplicationUserController {


    @Autowired
    public ApplicationUserController(){


    }


    @PostMapping("/register")
    public ResponseEntity<?> registerNewUser(@RequestBody ApplicationUserCreateDto applicationUserCreateDto){
        return ResponseEntity.ok("Salvo com sucesso");

    }
}
