package com.victorvilar.projetoempresa.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    //private signature key
    private final String SIGNATURE_KEY = "lmoybqnycrQtzhhq6F3HEovlVWEnAPzoMOmv6GgpCBM";



    private SecretKey encondeKey(){
        return Keys.hmacShaKeyFor(SIGNATURE_KEY.getBytes(StandardCharsets.UTF_8));
    }


    //generate a new jwt token
    public String generateJwtToken(Map<String,Object> claims){
        return Jwts.builder()
                .setIssuer("Rest Application by Victor Vilar")
                .setIssuedAt(new Date())
                .setClaims(claims)
                .signWith(this.encondeKey())
                .compact();
    }

    //validate a jwt token
    public Claims validateJwtToken(String token){
        try{
            return Jwts.parserBuilder()
                    .setSigningKey(this.encondeKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }catch(Exception e){
            throw new BadCredentialsException(("Invalid Token "));
        }
    }



}
