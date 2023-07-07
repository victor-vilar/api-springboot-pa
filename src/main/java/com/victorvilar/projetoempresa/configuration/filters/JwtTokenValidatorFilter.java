package com.victorvilar.projetoempresa.configuration.filters;

import com.victorvilar.projetoempresa.repository.ApplicationUserRepository;
import com.victorvilar.projetoempresa.services.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtTokenValidatorFilter extends OncePerRequestFilter {

    private final String TOKEN_HEADER = "Authorization";
    private ApplicationUserRepository applicationUserRepository;
    private final JwtService jwtService;

    public JwtTokenValidatorFilter(JwtService jwtService){
        this.jwtService =jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader(TOKEN_HEADER);
        System.out.println(request.getServletPath());

        if(token != null){

            String jwt = this.getAuthenticationTokenCode(token);
            Claims claims = this.jwtService.validateJwtToken(jwt);

            Authentication auth = new UsernamePasswordAuthenticationToken(claims.get("username"), null,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(claims.get("authorities").toString()));

            SecurityContextHolder.getContext().setAuthentication(auth);
            System.out.println(SecurityContextHolder.getContext().getAuthentication().toString());

        }


        filterChain.doFilter(request,response);
    }

    private String getAuthenticationTokenCode(String token){
        return token.substring(7);
    }

    /**
     * this filter doesn't need to be executed if the request path
     * is equals the login endpoint.
     * @param request
     * @return
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request){
        return request.getServletPath().equals("/v1/login");
    }
}
