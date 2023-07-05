package com.victorvilar.projetoempresa.domain.applicationuser.dto;

import com.victorvilar.projetoempresa.domain.applicationuser.ApplicationUserRole;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ApplicationUserResponseDto {


    private String username;
    private Set<String> roles = new HashSet<>();


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Set<String> getRoles() {
        return roles;
    }
    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public ApplicationUserResponseDto(){

    }

    public static ApplicationUserResponseDtoBuilder builder(){
        return new ApplicationUserResponseDtoBuilder();
    }

    public static class ApplicationUserResponseDtoBuilder{

        private String username;
        private Set<String> roles = new HashSet<>();

        public ApplicationUserResponseDtoBuilder username(String username){
            this.username =username;
            return this;
        }

        public ApplicationUserResponseDtoBuilder roles(Collection<? extends GrantedAuthority> roles){
            this.roles = (Set<String>)roles.stream().map(role -> role.getAuthority()).collect(Collectors.toSet());
            return this;
        }

        public ApplicationUserResponseDto build(){
            ApplicationUserResponseDto responseDto = new ApplicationUserResponseDto();
            responseDto.setUsername(this.username);
            responseDto.setRoles(this.roles);
            return responseDto;
        }

    }
}
