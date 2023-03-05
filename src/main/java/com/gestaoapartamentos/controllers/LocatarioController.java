package com.gestaoapartamentos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaoapartamentos.dto.LocatarioDto;
import com.gestaoapartamentos.services.LocatarioService;

@RestController
@RequestMapping("api/v1/locatario")
public class LocatarioController {
	
	public LocatarioService locatarioService;
	
	@PostMapping("/locatario/cadastro")
	public ResponseEntity<Object> cadastrarLocatario(@RequestBody LocatarioDto locatarioDto){
		return locatarioService.cadastrarLocatario(locatarioDto);
	}
}
