package com.gestaoapartamentos.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gestaoapartamentos.dto.LocadorDto;
import com.gestaoapartamentos.entities.Locador;
import com.gestaoapartamentos.repositories.LocadorRepository;

@Service
public class LocadorService {
	
	public LocadorRepository locadorRepository;
	
	public ResponseEntity<Object> cadastrarLocador(LocadorDto locadorDto){
		Optional<Locador> locadorOptional = locadorRepository.findByNome(locadorDto.getNome());
		if (locadorOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Este locador já está cadastrado.");
		}
		Locador locador = new Locador();
		BeanUtils.copyProperties(locadorDto, locador);
		locadorRepository.save(locador);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Locador cadastrado com sucesso!");
		
	}
}
