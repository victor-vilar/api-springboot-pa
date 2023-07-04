package com.victorvilar.projetoempresa.mappers;

import com.victorvilar.projetoempresa.controllers.dto.applicationuser.ApplicationUserCreateDto;
import com.victorvilar.projetoempresa.domain.applicationuser.ApplicationUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationUserMapper {

    private final ModelMapper mapper;

    @Autowired
    public ApplicationUserMapper(ModelMapper mapper){
        this.mapper = mapper;
    }

    public ApplicationUserCreateDto toApplicationUserDto(ApplicationUser applicationUser){
        return this.mapper.map(applicationUser, ApplicationUserCreateDto.class);
    }

    public ApplicationUser toApplicationUser(ApplicationUserCreateDto applicationUserCreateDto){
        return this.mapper.map(applicationUserCreateDto,ApplicationUser.class);
    }
}
