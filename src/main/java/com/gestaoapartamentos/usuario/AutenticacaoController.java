/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoapartamentos.usuario;

import com.gestaoapartamentos.security.TokenDto;
import com.gestaoapartamentos.security.TokenService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 *
 * @author jiulio
 */
@RestController
@RequestMapping("/api/v1/login")
public class AutenticacaoController {
    
    //classe do próprio Spring que dispara o processo de autenticação, chama a classe AutenticacaoService
    @Autowired
    private AuthenticationManager manager;
    
    @Autowired
    private TokenService tokenService;
    
    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid AutenticacaoDto autenticacaoDto){
        var authenticationToken = new UsernamePasswordAuthenticationToken(autenticacaoDto.login(), autenticacaoDto.senha());
        var authentication = manager.authenticate(authenticationToken);
        
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        
        return ResponseEntity.ok(new TokenDto(tokenJWT));
    }
    
}
