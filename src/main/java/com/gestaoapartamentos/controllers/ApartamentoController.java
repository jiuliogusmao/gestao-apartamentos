package com.gestaoapartamentos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaoapartamentos.dto.ApartamentoDto;
import com.gestaoapartamentos.services.ApartamentoService;

@RestController
@RequestMapping("api/v1/apartamento")
public class ApartamentoController {
	
public ApartamentoService apartamentoService;
	
	@PostMapping("/cadastro")
	public ResponseEntity<Object> cadastrarApartamento(@RequestBody ApartamentoDto apartamentoDto){
		return apartamentoService.cadastrarApartamento(apartamentoDto);
	}
}
