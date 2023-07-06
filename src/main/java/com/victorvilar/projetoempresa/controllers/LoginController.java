package com.victorvilar.projetoempresa.controllers;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.victorvilar.projetoempresa.domain.applicationuser.ApplicationUser;
import com.victorvilar.projetoempresa.domain.applicationuser.dto.ApplicationUserDto;
import com.victorvilar.projetoempresa.domain.applicationuser.dto.ApplicationUserResponseDto;
import com.victorvilar.projetoempresa.domain.applicationuser.mapper.ApplicationUserMapper;
import com.victorvilar.projetoempresa.repository.ApplicationUserRepository;
import com.victorvilar.projetoempresa.services.LoginService;
import com.victorvilar.projetoempresa.services.RegisterUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/login")
public class LoginController {

    private final RegisterUserService registerUserService;
    private final LoginService loginService;

    @Autowired
    public LoginController(
            RegisterUserService registerUserService,
            LoginService loginService
            ){
        this.registerUserService = registerUserService;
        this.loginService = loginService;

    }

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody ApplicationUserDto applicationuserDto){
        registerUserService.register(applicationuserDto);
        return ResponseEntity.ok("eee");
    }

    @GetMapping
    public ResponseEntity<ApplicationUserResponseDto> login(Authentication authentication){

        if(authentication != null){
            try {
                ApplicationUserResponseDto responseDto = this.loginService.getLoggedUserDetails(authentication);
                return ResponseEntity.ok(responseDto);
            }catch(UsernameNotFoundException e){
                System.out.println(e.getMessage());
            }
        }

        return ResponseEntity.badRequest().build();

    }



}
