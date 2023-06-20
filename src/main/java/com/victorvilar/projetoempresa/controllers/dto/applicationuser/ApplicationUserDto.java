package com.victorvilar.projetoempresa.controllers.dto.applicationuser;

import jakarta.validation.constraints.NotNull;

public class ApplicationUserDto {


    @NotNull(message = "The user must have a username")
    private String username;
    @NotNull(message = "the user must have a password")
    private String password;


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
}
