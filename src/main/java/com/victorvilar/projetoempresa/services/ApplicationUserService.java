package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.controllers.dto.applicationuser.ApplicationUserDto;
import com.victorvilar.projetoempresa.domain.ApplicationUser;
import com.victorvilar.projetoempresa.domain.Role;
import com.victorvilar.projetoempresa.mappers.ApplicationUserMapper;
import com.victorvilar.projetoempresa.repository.ApplicationUserRepository;
import com.victorvilar.projetoempresa.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ApplicationUserService {


    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserRepository applicationUserRepository;
    private final RolesRepository rolesRepository;
    private final ApplicationUserMapper mapper;

    @Autowired
    public ApplicationUserService(PasswordEncoder passwordEncoder,
                                  ApplicationUserRepository applicationUserRepository,
                                  RolesRepository rolesRepository,
                                  ApplicationUserMapper mapper) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserRepository = applicationUserRepository;
        this.rolesRepository = rolesRepository;
        this.mapper=mapper;
    }

    public ApplicationUser save(ApplicationUserDto applicationUserDto){

            ApplicationUser user = this.mapper.toApplicationUser(applicationUserDto);
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));
            Set<Role> roles = new HashSet<>();
            applicationUserDto.getRoles().forEach(role -> roles.add(this.rolesRepository.findByRoleName(role)));
            user.setRoles(roles);
            this.applicationUserRepository.save(user);
            return user;
    }

}
