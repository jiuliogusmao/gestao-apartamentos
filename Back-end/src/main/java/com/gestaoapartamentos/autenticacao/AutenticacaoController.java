/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoapartamentos.autenticacao;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestaoapartamentos.security.TokenDto;
import com.gestaoapartamentos.security.TokenService;
import com.gestaoapartamentos.usuario.Usuario;
import com.gestaoapartamentos.usuario.UsuarioDTO;

/**
 *
 * @author jiulio
 */
@Controller
@RequestMapping("/auth")
public class AutenticacaoController {


	@Autowired
	private TokenService tokenService;

	@GetMapping("/")
	public String paginaPrincipal() {
		return "index";
	}

	@GetMapping("/signup")
	public String getSignupPage() {
		return "signup"; // Nome da sua página de cadastro (signup.html)
	}

	@PostMapping("/signup")
	public ResponseEntity<Object> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDto) {
		return cadastrarUsuario(usuarioDto);
	}

	@GetMapping("/signin")
	public String getSigninPage() {
		return "signin"; // Nome da sua página de cadastro (signup.html)
	}

	@PostMapping("/signin")
	public ResponseEntity<Object> efetuarLogin(@RequestBody @Valid AutenticacaoDto autenticacaoDto, Errors erros,
			BindingResult result, Model model){
		return efetuarLogin(autenticacaoDto, erros, result, model);
	}
	
}
