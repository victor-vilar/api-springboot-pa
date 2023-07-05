package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.domain.applicationuser.dto.ApplicationUserDto;
import com.victorvilar.projetoempresa.services.RegisterUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/login")
public class LoginController {

    private final RegisterUserService registerUserService;

    @Autowired
    public LoginController(RegisterUserService registerUserService,
                           AuthenticationManager authenticationManager){
        this.registerUserService = registerUserService;

    }

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody ApplicationUserDto applicationuserDto){
        registerUserService.register(applicationuserDto);
        return ResponseEntity.ok("eee");
    }



}
