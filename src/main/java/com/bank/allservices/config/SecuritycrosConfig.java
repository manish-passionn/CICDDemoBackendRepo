package com.bank.allservices.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;

import org.springframework.web.cors.CorsConfiguration;

import org.springframework.web.cors.CorsConfigurationSource;

import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
 
import java.util.List;
 
@Configuration

public class SecuritycrosConfig {
 
	@Bean("securityFilterChainCors")

	public SecurityFilterChain corsSecurityFilterChain(HttpSecurity http) throws Exception{

        http.csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())

            .cors(cors -> cors.configurationSource(corscicdConfigurationSource())); // ✅ Use bean here

        return http.build();

    }
 
    @Bean("corscicdConfigurationSource")

    public CorsConfigurationSource corscicdConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(List.of("frontend-cicdservice.cicddemoapp.local")); // Frontend URL

        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        configuration.setAllowedHeaders(List.of("*"));

        configuration.setAllowCredentials(true); // ✅ If you need cookies/JWT
 
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;

    }
 
}

 
