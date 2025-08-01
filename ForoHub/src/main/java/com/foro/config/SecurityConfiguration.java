package com.foro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf ->csrf
                        .ignoringRequestMatchers("/topicos/**")
                )
                .authorizeHttpRequests(auth ->auth
                        .anyRequest().permitAll()
                )
                .build();
    }
}
