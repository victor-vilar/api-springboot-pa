package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.domain.applicationuser.ApplicationUser;
import com.victorvilar.projetoempresa.domain.applicationuser.dto.ApplicationUserDto;
import com.victorvilar.projetoempresa.domain.applicationuser.dto.ApplicationUserResponseDto;
import com.victorvilar.projetoempresa.domain.applicationuser.mapper.ApplicationUserMapper;
import com.victorvilar.projetoempresa.repository.ApplicationUserRepository;
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
    private final ApplicationUserMapper mapper;
    private final ApplicationUserRepository userRepository;

    @Autowired
    public LoginController(
            RegisterUserService registerUserService,
            ApplicationUserRepository userRepository
            ,ApplicationUserMapper mapper){
        this.registerUserService = registerUserService;
        this.userRepository = userRepository;
        this.mapper = mapper;

    }

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody ApplicationUserDto applicationuserDto){
        registerUserService.register(applicationuserDto);
        return ResponseEntity.ok("eee");
    }

    @GetMapping
    public ResponseEntity<ApplicationUserResponseDto> login(Authentication authentication){

        if(authentication != null){
            //get the user information or throws UserNotFoundException
            ApplicationUser user = this.userRepository.findByUsername(authentication.getName())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found !"));

            ApplicationUserResponseDto applicationUserResponseDto = this.mapper.toApplicationUserResponseDto(user);

            return ResponseEntity.ok(applicationUserResponseDto);
        }else{
            return ResponseEntity.badRequest().build();
        }

    }



}
