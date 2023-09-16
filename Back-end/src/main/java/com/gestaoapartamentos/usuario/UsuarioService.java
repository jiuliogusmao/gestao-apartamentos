package com.gestaoapartamentos.usuario;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;

import com.gestaoapartamentos.autenticacao.AutenticacaoDto;
import com.gestaoapartamentos.security.TokenDto;
import com.gestaoapartamentos.security.TokenService;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	// classe do próprio Spring que dispara o processo de autenticação, chama a
	// classe AutenticacaoService
	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private TokenService tokenService;

	public ResponseEntity<Object> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDto) {
		if (usuarioRepository.findByUsername(usuarioDto.getUsername()) != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuario já existe!");
		}

		Usuario usuario = new Usuario(usuarioDto.getUsername(), passwordEncoder.encode(usuarioDto.getPassword()));
		usuarioRepository.save(usuario);

		String token = tokenService.gerarToken(usuario);// Gera um token JWT
		return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso!" + token);
	}

	public ResponseEntity<Object> efetuarLogin(@RequestBody @Valid AutenticacaoDto autenticacaoDto, Errors erros,
			BindingResult result, Model model) {
		if (result.hasErrors() || (null != erros && erros.getErrorCount() > 0)) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("signin");
		}
		try {
			var authenticationToken = new UsernamePasswordAuthenticationToken(autenticacaoDto.login(),
					autenticacaoDto.senha());
			var authentication = manager.authenticate(authenticationToken);
			
			var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
			
			return ResponseEntity.status(HttpStatus.OK).body(new TokenDto(tokenJWT));
			
		}catch (AuthenticationException ex) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Retorna erro de autenticação
	    }
	}

}
