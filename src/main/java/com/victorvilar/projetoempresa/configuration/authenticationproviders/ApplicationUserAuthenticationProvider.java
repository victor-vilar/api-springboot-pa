package com.victorvilar.projetoempresa.configuration.authenticationproviders;

import com.victorvilar.projetoempresa.domain.applicationuser.ApplicationUser;
import com.victorvilar.projetoempresa.domain.applicationuser.ApplicationUserRole;
import com.victorvilar.projetoempresa.repository.ApplicationUserRolesRepository;
import com.victorvilar.projetoempresa.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ApplicationUserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private ApplicationUserRolesRepository rolesRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        ApplicationUser user = this.applicationUserRepository.findByUsername(authentication.getName()).orElseThrow(() ->new RuntimeException("Não há"));
        System.out.println(user);
        String encodedPassword = this.passwordEncoder.encode(authentication.getCredentials().toString());

        if(user != null && this.passwordEncoder.matches(user.getPassword(),encodedPassword)){
            System.out.println(user);
            List<ApplicationUserRole> roles = this.rolesRepository.findByApplicationUsers(user);
            return new UsernamePasswordAuthenticationToken(authentication.getName(),null,roles);
       }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}