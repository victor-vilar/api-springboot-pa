package com.victorvilar.projetoempresa.configuration;

import com.victorvilar.projetoempresa.domain.ApplicationUser;
import com.victorvilar.projetoempresa.domain.Role;
import com.victorvilar.projetoempresa.repository.RolesRepository;
import com.victorvilar.projetoempresa.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationUserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private RolesRepository rolesRepository;
    

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        ApplicationUser user = this.applicationUserRepository.findByUsername(authentication.getName());

        if(user != null){

            List<Role> roles = this.rolesRepository.findByApplicationUsers(user);
            List<GrantedAuthority> autorities = new ArrayList<>();
            roles.stream().forEach(role -> autorities.add(new SimpleGrantedAuthority(role.getRoleName())));
            return new UsernamePasswordAuthenticationToken(authentication.getName(),authentication.getCredentials(),autorities);
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
