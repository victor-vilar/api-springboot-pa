package com.victorvilar.projetoempresa.domain.applicationuser.mapper;

import com.victorvilar.projetoempresa.domain.applicationuser.ApplicationUser;
import com.victorvilar.projetoempresa.domain.applicationuser.dto.ApplicationUserDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ApplicationUserMapper {

    private final ModelMapper mapper;

    public ApplicationUserMapper(ModelMapper mapper){
        this.mapper=mapper;
    }

    public ApplicationUser toApplicationUser(ApplicationUserDto userDto){
        return this.mapper.map(userDto,ApplicationUser.class);
    }

    public ApplicationUserDto toApplicationUserDto(ApplicationUser applicationUser){
        return this.mapper.map(applicationUser, ApplicationUserDto.class);
    }



}
