package com.gestaoapartamentos.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gestaoapartamentos.dto.ApartamentoDto;
import com.gestaoapartamentos.entities.Apartamento;
import com.gestaoapartamentos.repositories.ApartamentoRepository;

@Service
public class ApartamentoService {
	
	private ApartamentoRepository apartamentoRepository;
	
	public ResponseEntity<Object> cadastrarApartamento(ApartamentoDto apartamentoDto){
		Optional<Apartamento> apartamentoOptional = apartamentoRepository.findByNumeroApartamento(apartamentoDto.getNumeroApartamento());
		if (apartamentoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Este apartamento já está cadastrado.");
		}
		Apartamento apartamento = new Apartamento();
		BeanUtils.copyProperties(apartamentoDto, apartamento);
		apartamentoRepository.save(apartamento);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Apartamento cadastrado com sucesso!");
		
	}
}
