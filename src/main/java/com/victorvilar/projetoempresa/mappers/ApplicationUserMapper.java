package com.victorvilar.projetoempresa.mappers;

import com.victorvilar.projetoempresa.controllers.dto.applicationuser.ApplicationUserDto;
import com.victorvilar.projetoempresa.domain.ApplicationUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationUserMapper {

    private final ModelMapper mapper;

    @Autowired
    public ApplicationUserMapper(ModelMapper mapper){
        this.mapper = mapper;
    }

    public ApplicationUserDto toApplicationUserDto(ApplicationUser applicationUser){
        return this.mapper.map(applicationUser, ApplicationUserDto.class);
    }

    public ApplicationUser toApplicationUser(ApplicationUserDto applicationUserDto){
        return this.mapper.map(applicationUserDto,ApplicationUser.class);
    }
}
