package com.gestaoapartamentos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaoapartamentos.dto.LocadorDto;
import com.gestaoapartamentos.services.LocadorService;

@RestController
@RequestMapping("api/v1/locador")
public class LocadorController {

	public LocadorService locadorService;
	
	@PostMapping("/locador/cadastro")
	public ResponseEntity<Object> cadastrarLocador(@RequestBody LocadorDto locadorDto){
		return locadorService.cadastrarLocador(locadorDto);
	}
}
