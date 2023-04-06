/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoapartamentos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author jiulio
 */
@Configuration
@EnableWebSecurity //configuração personalizada
public class SecurityConfig {
    
    @Bean //Um Bean serve para exportar uma classe para o Spring, para que ele consiga carregá-la e realize sua injeção de dependência em outras classes
    //configuração do processo de autenticação (Stateless)
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
    //desabilita a proteção contra ataques tipo cross-site request forgery. Como será usado o token, manter essa proteção habilitada é reduntante.
        return http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //desabilita o formulário statefull do spring e configura stateless
                .and().build();
    }
    
    @Bean //instancia um objeto AuthenticationManager responsável por processar a autenticação de um objeto passado.
    public AuthenticationManager authenticationmanager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }
    
    @Bean //indica para o Spring qual o algorítmo de encriptação será utilizado
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
