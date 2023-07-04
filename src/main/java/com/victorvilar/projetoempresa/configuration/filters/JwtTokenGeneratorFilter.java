package com.victorvilar.projetoempresa.configuration.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtTokenGeneratorFilter extends OncePerRequestFilter {

    private final String TOKEN_HEADER = "Authorization";


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


            //check if an authentication is saved
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            //if authentication != null
            if(authentication != null){




            }

            System.out.println(token);
    }
}
