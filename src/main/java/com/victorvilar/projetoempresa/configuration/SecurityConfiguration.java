package com.victorvilar.projetoempresa.configuration;

import com.victorvilar.projetoempresa.configuration.filters.CsrfCookieSessionFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                //informa para o spring que é de responsabilidade dele de salvar os dados dentro do SecurityHolder
                .securityContext( security ->{
                    security.requireExplicitSave(false);
                })
//                //informa ao spring para sempre gerar o JSessionId
                .sessionManagement(session -> session
                    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)

                )
                //cors configuration
                .cors(cors ->cors
                    .configurationSource(new CorsConfiguration())
                )

                //csrf configuration
                .csrf(csrf -> csrf
                        //include de csrf token as attribute of respose
                        .csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler())
                        //end points that not have a csrf protection
                        .ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2/**"))
                        //repository of csrf tokens
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                      .disable()
                )

                //send a csrf token to request after an authentication
                .addFilterAfter(new CsrfCookieSessionFilter(), BasicAuthenticationFilter.class)

                //end points configuration and roles
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/residue","/h2/**","/login-page").permitAll()
                    .anyRequest().authenticated()

                )

                //configuration to h2 database
                .headers(header-> header
                                .frameOptions(frame -> frame.disable())
                )

                //default login page configuration
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());



        return http.build();
    }


}
