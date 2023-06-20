package com.victorvilar.projetoempresa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


    @Bean
    public UserDetailsService userDetails(){
        UserDetails admin = User.builder()
                .username("admin")
                .password("12345")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                //cors configuration
                .cors(cors ->cors
                    .configurationSource(new CorsConfiguration())
                )

                //csrf configuration
                .csrf(csrf -> csrf
                    .csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler())
                        .ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2/**"))
                )

                //end points configuration and roles
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/residue","/h2/*").permitAll()
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
