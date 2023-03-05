package com.gestaoapartamentos.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gestaoapartamentos.dto.EdificioDto;
import com.gestaoapartamentos.entities.Edificio;
import com.gestaoapartamentos.repositories.EdificioRepository;

@Service
public class EdificioService {
	
	private EdificioRepository edificioRepository;
	
	public ResponseEntity<Object> cadastrarEdificio(EdificioDto edificioDto){
		Optional<Edificio> edificioOptional = edificioRepository.findByNome(edificioDto.getNome());
		if (edificioOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Este edifício já está cadastrado.");
		}
		Edificio edificio = new Edificio();
		BeanUtils.copyProperties(edificioDto, edificio);
		edificioRepository.save(edificio);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Edifício cadastrado com sucesso!");
		
	}
	
	
}
