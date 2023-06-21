package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.applicationuser.ApplicationUserDto;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class LoginController {

    @GetMapping("/login-page")
    public ApplicationUserDto login(Authentication authentication){
        ApplicationUserDto userDto = new ApplicationUserDto();
        userDto.setUsername(authentication.getName());
        userDto.setRoles(authentication.getAuthorities());
        return userDto;
    }

}
