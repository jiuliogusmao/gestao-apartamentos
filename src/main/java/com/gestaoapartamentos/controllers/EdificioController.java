package com.gestaoapartamentos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaoapartamentos.dto.EdificioDto;
import com.gestaoapartamentos.services.EdificioService;

@RestController
@RequestMapping("api/v1/edificio")
public class EdificioController {
public EdificioService edificioService;
	
	@PostMapping("/edificio/cadastro")
	public ResponseEntity<Object> cadastrarEdificio(@RequestBody EdificioDto edificioDto){
		return edificioService.cadastrarEdificio(edificioDto);
	}
}
