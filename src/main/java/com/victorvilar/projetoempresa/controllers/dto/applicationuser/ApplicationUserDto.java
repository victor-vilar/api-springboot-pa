package com.victorvilar.projetoempresa.controllers.dto.applicationuser;

import com.victorvilar.projetoempresa.domain.Role;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ApplicationUserDto {


    @NotNull(message = "The user must have a username")
    private String username;
    @NotNull(message = "the user must have a password")
    private String password;
    @NotNull(message="the user must have at least one role")
    private Set<String> roles = new HashSet<>();


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        roles.forEach(role -> this.roles.add(role.getAuthority()));

    }
}
