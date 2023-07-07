package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.domain.applicationuser.ApplicationUser;
import com.victorvilar.projetoempresa.domain.applicationuser.dto.ApplicationUserResponseDto;
import com.victorvilar.projetoempresa.domain.applicationuser.mapper.ApplicationUserMapper;
import com.victorvilar.projetoempresa.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final ApplicationUserMapper mapper;
    private final ApplicationUserRepository userRepository;

    @Autowired
    public LoginService(
            ApplicationUserMapper mapper,
            ApplicationUserRepository userRepository
    ){
        this.mapper=mapper;
        this.userRepository= userRepository;
    }

    /**
     * get information from an Authentication Object to send after a
     * sign in
     * @param authentication Authentication Object created by Spring
     * @return An ApplicationUserResponseDto, to be possible to get the profilePhotoUrl
     */
    public ApplicationUserResponseDto getLoggedUserDetails(Authentication authentication) throws UsernameNotFoundException{

        //get userApplication from database
        ApplicationUser user = this.userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not found !"));

        //convert to Dto
        ApplicationUserResponseDto applicationUserResponseDto = this.mapper.toApplicationUserResponseDto(user);

        //return
        return applicationUserResponseDto;
    }

}