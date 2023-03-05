package com.gestaoapartamentos.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gestaoapartamentos.dto.LocatarioDto;
import com.gestaoapartamentos.entities.Locatario;
import com.gestaoapartamentos.repositories.LocatarioRepository;

@Service
public class LocatarioService {
	
	public LocatarioRepository locatarioRepository;
	
	public ResponseEntity<Object> cadastrarLocatario(LocatarioDto locatarioDto){
		Optional<Locatario> locatarioOptional = locatarioRepository.findByNome(locatarioDto.getNome());
		
		if(locatarioOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Este locatario já existe.");
		}
		Locatario locatario = new Locatario();
		BeanUtils.copyProperties(locatarioDto, locatario);
		locatarioRepository.save(locatario);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Locatário criado com sucesso!");
	}
}
